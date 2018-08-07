package com.example.myshop.utils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // request에 시간을 보내면 컨트롤러에도 값이 가니까 컨트롤러가 실행한 시간을 구할 수 있다.
//        request.setAttribute("startTime",System.nanoTime());
        LogContext.time.set(System.nanoTime());
        System.out.println("preHandler : " + handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime =  System.nanoTime();
//        long startTime = (long) request.getAttribute("startTime");
//        long result = endTime - startTime;
        long startTime = LogContext.time.get(); // 현재 스레드를 기준으로 값을 꺼낸다.
        System.out.println("postHandler : "+(endTime-startTime));
    }
}
