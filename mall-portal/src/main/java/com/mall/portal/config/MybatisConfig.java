package com.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: mall-springclound
 * @description: Mybatis配置类
 * @author: gaojme
 * @create: 2020-04-10 16:29
 */
@Configuration
@EnableTransactionManagement   //Spring Boot 使用事务， 开启事务支持，之后再数据库访问层Service方法上添加@Transactional即可
@MapperScan({"com.mall.mapper", "com.mall.portal.dao"})
public class MybatisConfig {



}
