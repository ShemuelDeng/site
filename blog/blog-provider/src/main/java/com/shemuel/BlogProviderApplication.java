package com.shemuel;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient // 开启eureka客户端, 此provider作为 eureka客户端向服务断注册服务
@MapperScan("com.shemuel.dao")
public class BlogProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogProviderApplication.class, args);
    }
}
