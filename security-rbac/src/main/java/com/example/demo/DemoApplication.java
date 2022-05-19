package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Where.LIU
 */
@SpringBootApplication
@ServletComponentScan
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        try (ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args)) {
//            log.info("Application running.");
//        }
    }
}
