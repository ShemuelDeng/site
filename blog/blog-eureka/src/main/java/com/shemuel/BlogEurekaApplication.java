package com.shemuel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer       // 开启eureka服务
public class BlogEurekaApplication{
    public static void main(String[] args) {
        SpringApplication.run(BlogEurekaApplication.class, args);
    }

}
