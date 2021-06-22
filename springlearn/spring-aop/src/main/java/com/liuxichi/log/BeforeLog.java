package com.liuxichi.log;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLog implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("类"+target.getClass().getName()+"使用了方法："+method.getName());
    }
    
}
