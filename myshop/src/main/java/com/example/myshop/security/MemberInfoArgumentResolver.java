package com.example.myshop.security;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class MemberInfoArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if(parameter.getParameterType() == MemberInfo.class) //  클래스 정보는 한번만 올라가서 '=='로 비교해도 된다.
            return true;
        return false;

    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        MemberInfo memberInfo = new MemberInfo(5L, "jinioh88@gmail.com");
        return memberInfo;
    }
}
