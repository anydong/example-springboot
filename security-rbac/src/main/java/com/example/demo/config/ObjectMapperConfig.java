package com.example.demo.config;

import com.example.demo.util.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Configuration
public class ObjectMapperConfig {
    @Bean
    public ObjectMapper objectMapper() {
        return JSONUtil.MAPPER;
    }
}
