package com.example.demo.controller;

import com.alibaba.cola.dto.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
@RestController
public class IndexController {
    @GetMapping("index")
    public Response index() {
        return Response.buildSuccess();
    }
}
