package com.shemuel.config;

import com.shemuel.interceptor.HandleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// webmvcConfigurer 接口替换了以前的webmvcConfigurAdapter类
@org.springframework.context.annotation.Configuration
public class Configuration implements WebMvcConfigurer {
    @Autowired
    private HandleInterceptor handleInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 取消对静态资源的拦截
        registry.addInterceptor(handleInterceptor).addPathPatterns("/*").excludePathPatterns("classpath:/static/");
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
