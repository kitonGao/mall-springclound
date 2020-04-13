package com.mall.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: mall-springclound
 * @description:
 * @author: gaojme
 * @create: 2020-04-10 17:32
 */
@EnableDiscoveryClient    //启用服务注册功能，注册到eureka
@EnableAdminServer  //启用Spring-Boot-Admin的admin-server功能
@SpringBootApplication
public class MallMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMonitorApplication.class, args);
    }

}
