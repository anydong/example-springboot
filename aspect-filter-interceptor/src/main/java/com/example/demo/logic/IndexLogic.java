package com.example.demo.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IndexLogic {
    public String index() {
        return "hello world";
    }
}
