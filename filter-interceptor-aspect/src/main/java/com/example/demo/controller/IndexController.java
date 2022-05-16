package com.example.demo.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(value = "/")
    public String index(@Nullable @RequestParam String error) {
        if (null != error) {
            throw new RuntimeException(error);
        }
        return "hello-world";
    }
}
