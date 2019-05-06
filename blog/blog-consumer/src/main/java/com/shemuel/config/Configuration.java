package com.shemuel.config;

import com.shemuel.interceptor.HandleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// webmvcConfigurer 接口替换了以前的webmvcConfigurAdapter类
@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {
    @Autowired
    private HandleInterceptor handleInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //
        registry.addInterceptor(handleInterceptor).addPathPatterns("/index","/home", "/");
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
