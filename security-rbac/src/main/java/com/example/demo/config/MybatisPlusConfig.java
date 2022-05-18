package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Configuration
@MapperScan(value = {"com.example.demo.mapper"})
public class MybatisPlusConfig {
}
