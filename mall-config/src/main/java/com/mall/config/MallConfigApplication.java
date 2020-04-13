package com.mall.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: mall-springclound
 * @description:
 * @author: gaojme
 * @create: 2020-04-13 09:24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer    //Spring cloud config server使用的注解，
public class MallConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallConfigApplication.class, args);
    }

}
