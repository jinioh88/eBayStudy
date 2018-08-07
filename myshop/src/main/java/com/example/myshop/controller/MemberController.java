package com.example.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    @GetMapping
    public String members(ModelMap model) {
        model.addAttribute("count",500);
        return "member";
    }
}
