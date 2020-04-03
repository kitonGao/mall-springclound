package com.mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @program: mall-springclound
 * @description: 全局跨域配置(注：前端从网关进行调用时需要配置)
 * @author: gaojme
 * @create: 2020-03-31 17:51
 */
@Configuration
public class GlobalCorsConfig {


    @Bean
    public CorsWebFilter corsWebFilter(){
        CorsConfiguration cofig = new CorsConfiguration();
        cofig.addAllowedMethod("*");
        cofig.addAllowedOrigin("*");
        cofig.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cofig);

        return new CorsWebFilter(source);

    }



}
