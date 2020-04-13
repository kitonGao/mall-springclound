package com.mall.portal.service.impl;

import com.mall.common.exception.Exceptions;
import com.mall.mbg.entity.UmsMember;
import com.mall.mbg.entity.UmsMemberExample;
import com.mall.mbg.entity.UmsMemberLevel;
import com.mall.mbg.entity.UmsMemberLevelExample;
import com.mall.mbg.mapper.UmsMemberLevelMapper;
import com.mall.mbg.mapper.UmsMemberMapper;
import com.mall.portal.domain.MemberDetails;
import com.mall.portal.service.RedisService;
import com.mall.portal.service.UmsMemberService;
import com.mall.security.util.JwtTokenUtil;
import io.jsonwebtoken.lang.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Random;

/**
 * @program: mall-springclound
 * @description: 会员管理Service
 * @author: gaojme
 * @create: 2020-04-10 17:10
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsMemberServiceImpl.class);


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsMemberMapper umsMemberMapper;
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;





    @Override
    public UmsMember getByUsername(String username) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> umsMemberList = umsMemberMapper.selectByExample(example);
        if (!Collections.isEmpty(umsMemberList)) {
            return umsMemberList.get(0);
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return umsMemberMapper.selectByPrimaryKey(id);
    }

    @Override
    public void register(String username, String password, String telephone, String authCode) {
        //验证验证码
        if (!checkAuthCode(authCode, telephone)) {
            Exceptions.fail("验证码错误");
        }
        //查询用户是否存在
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<UmsMember> umsMemberList = umsMemberMapper.selectByExample(example);
        if (!Collections.isEmpty(umsMemberList)) {
            Exceptions.fail("该用户已经存在");
        }
        //如果没有改用户进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPassword(password);
        umsMember.setPhone(telephone);
        umsMember.setPassword(password);
        umsMember.setStatus(1);
        //获取默认会员等级并设置
        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!Collections.isEmpty(memberLevelList)) {
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        umsMemberMapper.insert(umsMember);
        //TODO 插入后将密码置为空
        umsMember.setPassword(null);
    }



    @Override
    public String generateAutoCode(String telephone) {
//        StringBuffer   线程安全
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i =0; i< 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, stringBuilder.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone, AUTH_CODE_EXPIRE_SECONDS);
        return stringBuilder.toString();
    }

    @Override
    public void updatePassword(String telephone, String password, String authCode) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = umsMemberMapper.selectByExample(example);
        if (Collections.isEmpty(memberList)){
            Exceptions.fail("该账号不存在");
        }
        //验证验证码
        if (!checkAuthCode(authCode, telephone)){
            Exceptions.fail("验证码错误");
        }
        UmsMember umsMember1 = new UmsMember();
        umsMember1.setId(memberList.get(0).getId());
        umsMember1.setPassword(passwordEncoder.encode(password));
        umsMemberMapper.updateByPrimaryKeySelective(umsMember1);
    }

    @Override
    public UmsMember getCurrentMember() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        MemberDetails memberDetails = (MemberDetails)authentication.getPrincipal();
        return memberDetails.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember umsMember = new UmsMember();
        umsMember.setId(id);
        umsMember.setIntegration(integration);
        umsMemberMapper.updateByPrimaryKeySelective(umsMember);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsMember member = getByUsername(username);
        if (member != null){
            return new MemberDetails(member);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递

        try{
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String code) {
        return jwtTokenUtil.updateHeadToken(code);
    }


    /**
     * 对输入的验证码校验
     * @param authCode
     * @param telephone
     * @return
     */
    private boolean checkAuthCode(String authCode, String telephone) {
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }
        String realAuthcode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        return realAuthcode.equals(authCode);
    }

}
