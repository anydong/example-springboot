package com.example.demo.controller;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.auth.request.UserRegisterCmd;
import com.example.demo.logic.AuthLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author where
 */
@RestController
@RequestMapping(value = "/auth", name = "鉴权相关接口")
public class AuthController {
    private final AuthLogic authLogic;

    @Autowired
    public AuthController(AuthLogic authLogic) {
        this.authLogic = authLogic;
    }

    @PostMapping(value = "/register", name = "用户注册")
    public Response register(@Valid @RequestBody UserRegisterCmd cmd) {
        return authLogic.register(cmd);
    }
}
