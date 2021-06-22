package com.liuxichi.log;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterLog implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("类"+target.getClass().getName()+"使用了方法："+method.getName()+",值为："+returnValue);
    }

}
