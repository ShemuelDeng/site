package com.shemuel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 开启eureka客户端, 此provider作为 eureka客户端向服务断注册服务
public class BlogProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogProviderApplication.class, args);
    }
}
