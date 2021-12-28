package com.example.cola.adapter.api.controller;

import com.alibaba.cola.dto.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @PostMapping(value = "/register", name = "注册")
    public Response register() {
        return null;
    }
}
