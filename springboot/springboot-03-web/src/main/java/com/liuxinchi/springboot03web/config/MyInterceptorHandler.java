package com.liuxinchi.springboot03web.config;

import com.liuxinchi.springboot03web.pojo.Employee;
import com.liuxinchi.springboot03web.utils.Constant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptorHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getAttribute(Constant.EMPLOYEE_SESSION)==null){
            request.setAttribute("msg","没有权限，请登陆！");
            request.getRequestDispatcher("/index").forward(request,response);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
