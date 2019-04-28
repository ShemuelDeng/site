package com.shemuel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BlogEureka7001Application {
    public static void main(String[] args) {
        SpringApplication.run(BlogEureka7001Application.class, args);
    }
}
