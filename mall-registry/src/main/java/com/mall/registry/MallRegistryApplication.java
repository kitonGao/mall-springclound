package com.mall.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: mall-springclound
 * @description:
 * @author: gaojme
 * @create: 2020-03-31 17:18
 */
@SpringBootApplication
@EnableEurekaServer
public class MallRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallRegistryApplication.class, args);
    }


}
