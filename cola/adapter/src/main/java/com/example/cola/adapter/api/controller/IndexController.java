package com.example.cola.adapter.api.controller;

import com.example.cola.adapter.api.logic.IndexLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private IndexLogic indexLogic;
}
