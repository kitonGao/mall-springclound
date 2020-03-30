package com.mall.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mall-springclound
 * @description: 用于配置不需要保护的资源路径
 * @author: gaojme
 * @create: 2020-03-30 17:46
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {


    private List<String> urls = new ArrayList<>();



}
