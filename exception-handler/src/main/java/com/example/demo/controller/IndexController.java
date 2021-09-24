package com.example.demo.controller;

import com.example.demo.exception.ApplicationException;
import com.example.demo.exception.ValidateException;
import com.example.demo.query.RegisterQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class IndexController {
    @GetMapping(value = "/")
    public String index() {
        return "Hello world";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RegisterQuery register(@Valid @RequestBody RegisterQuery query) throws ValidateException {
        if (!StringUtils.equals(query.getPassword(), query.getPasswordConfirmation())) {
            throw new ValidateException("password", "密码不一致");
        }
        return query;
    }
}
