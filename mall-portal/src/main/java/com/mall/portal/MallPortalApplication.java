package com.mall.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: mall-springclound
 * @description:
 * @author: gaojme
 * @create: 2020-04-10 15:11
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.mall")
public class MallPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPortalApplication.class, args);
    }

}
