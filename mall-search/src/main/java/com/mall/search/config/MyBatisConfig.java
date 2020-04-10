package com.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mall-springclound
 * @description: Mybatis配置类
 * @author: gaojme
 * @create: 2020-04-10 09:23
 */
@Configuration
@MapperScan({"com.mall.mapper", "com.mall.search.dao"})
public class MyBatisConfig {


}
