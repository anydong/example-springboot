package com.example.demo.controller;

import com.example.demo.logic.IndexLogic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {
    @Resource
    private IndexLogic indexLogic;

    @GetMapping(value = "/")
    public String index() {
        return indexLogic.index();
    }
}
