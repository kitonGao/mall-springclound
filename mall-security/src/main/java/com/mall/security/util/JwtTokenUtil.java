package com.mall.security.util;

import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: mall-springclound
 * @description:
 *  JwtToken生成工具类
 *      JWT token的格式：header.payload.signature
 *
 *      header的格式：算法,token的类型
 *          {"alg":"HS512", "type":"JWT"}
 *      payload的格式：用户名，创建时间，生成时间
 *          {"sub":"wang", "created":1489079981393, "exp":1489079981342}
 *      signature的生成算法
 *          HMACSHA512(base64UrlEncode(header) +"." + base64UrlEncode(payload), secret )
 *
 * @author: gaojme
 * @create: 2020-03-30 17:03
 */
public class JwtTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.tokenHead}")
    private String tokenHead;



    /**
     * 根据负责生成JWT的token
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                //
                .setClaims(claims)
                //设置过期时间
                .setExpiration(generateExpirationDate())
                //签名算法
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    /**
     * 从token中获取JWT的负载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {

            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e) {
            LOGGER.error("JWT格式验证失败：{}" , token);
        }
        return claims;
    }


    /**
     * 生成token的过期时间
     * @return
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }


    /**
     * 从token中获取登录用户名
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token){
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e) {
            username = null;
        }
        return username;
    }


    /**
     * 验证token是否还有效
     * @param token 客户端传入的token
     * @param userDetails   从数据库中查询出来的用户信息
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);

    }


    /**
     * 判断token是否已经失效
     * @param token
     * @return 返回true 表示失效， false：表示还有效
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }


    /**
     * 根据用户信息生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }


    /**
     * 当原来的token没过期时可以刷新
     * @param oldToken  带tokenHead的token
     * @return
     */
    public String updateHeadToken(String oldToken) {
        if (StringUtils.isEmpty(oldToken)) {
            return null;
        }
        String token = oldToken.substring(tokenHead.length());
        if (StringUtils.isEmpty(token)) {
            return null;
        }

        //校验token不通过
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return null;
        }

        //如果token在30分钟之内刚刷新过，返回原token
        if (tokenUpdateJustBefore(token, 30*60)) {
            return token;
        } else {
            claims.put(CLAIM_KEY_CREATED, new Date());
            return generateToken(claims);
        }
    }


    /**
     *
     * 判断token在指定时间内是否刚刚刷新过
     * @param token 原token
     * @param time  指定时间(秒)
     * @return
     *
     */
    private boolean tokenUpdateJustBefore(String token, int time) {
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date updateDate = new Date();
        //刷新时间在创建时间的指定时间内
        if (updateDate.after(created) && updateDate.before(DateUtil.offsetSecond(created, time))) {
            return true;
        }
        return false;
    }



}
