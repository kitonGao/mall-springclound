package com.mall.portal.config;

import com.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @program: mall-springclound
 * @description: mall-security 模块相关配置
 * @author: gaojme
 * @create: 2020-04-10 17:06
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MallSecurityConfig {


    @Autowired
    private UmsMemberService memberService;


    public UserDetailsService userDetailsService(){
        //获取登录用户信息
//        return username -> memberService.loadUserByUsername(username);
        return null;
    }




}
