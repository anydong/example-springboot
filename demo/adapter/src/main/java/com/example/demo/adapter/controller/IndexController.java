package com.example.demo.adapter.controller;

import com.alibaba.cola.dto.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author where
 */
@RestController
public class IndexController {
    @GetMapping(value = "/", name = "index")
    public Response index() {
        return Response.buildSuccess();
    }
}
