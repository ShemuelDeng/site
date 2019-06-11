package com.shemuel.config;

import com.shemuel.interceptor.HandleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// webmvcConfigurer 接口替换了以前的webmvcConfigurAdapter类
@org.springframework.context.annotation.Configuration
@Component
public class Configuration implements WebMvcConfigurer {
    @Autowired
    private HandleInterceptor handleInterceptor;
    public void addInterceptors(InterceptorRegistry registry) {
        //
        registry.addInterceptor(handleInterceptor).addPathPatterns("/index","/home", "/");
    }

}
