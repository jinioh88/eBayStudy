package com.example.myshop.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "hello "+name;
    }
}
