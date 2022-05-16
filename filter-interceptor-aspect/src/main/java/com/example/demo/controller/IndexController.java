package com.example.demo.controller;

import com.example.demo.logic.IndexLogic;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {
    @Resource
    private IndexLogic indexLogic;

    @GetMapping(value = "/")
    public String index(@Nullable @RequestParam String error) {
        if (null != error) {
            throw new RuntimeException(error);
        }
        return indexLogic.index();
    }
}
