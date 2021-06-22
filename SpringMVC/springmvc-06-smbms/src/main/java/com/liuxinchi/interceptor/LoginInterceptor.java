package com.liuxinchi.interceptor;

import com.liuxinchi.utils.Constant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute(Constant.USER_SESSION)==null){
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
