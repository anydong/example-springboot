package com.example.demo.config;

import com.example.demo.interceptor.ApiAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author where
 */
@Configuration
public class CustomerWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    private ApiAuthInterceptor apiAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiAuthInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/auth/register", "/auth/login");
    }
}
