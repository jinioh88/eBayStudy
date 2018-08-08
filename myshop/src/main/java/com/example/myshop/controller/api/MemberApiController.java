package com.example.myshop.controller.api;

import com.example.myshop.security.MemberInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/members")
public class MemberApiController {
    @GetMapping
    public String member(MemberInfo memberInfo) { // 디스패처 서블릿이 타입이 있으면 값을 채워 넣어줌. 아규먼트 리졸버
        System.out.println("members : "+memberInfo);
        return "member";
    }

    @GetMapping("2")
    public String num(HttpServletRequest request) {
        String name = request.getParameter("name");

        return name;
    }
}
