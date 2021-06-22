package com.liuxichi.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnoLog {
    @Before("execution(* com.liuxichi.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("==========切入前=========");
    }
    
    @After("execution(* com.liuxichi.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("==========切入后=========");
    }

    @Around("execution(* com.liuxichi.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("环绕前");
        Object proceed = jp.proceed();
        System.out.println("环绕后");
    }
}
