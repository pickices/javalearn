package com.liuxinchi.demo4;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxy implements InvocationHandler{

    private UserServiceImpl target;

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logs(method);
        method.invoke(target, args);
        return null;
    }

    public UserServiceImpl getTarget() {
        return target;
    }

    public void setTarget(UserServiceImpl target) {
        this.target = target;
    }

    public void logs(Method method){

        System.out.println(method.getName());
    }

    
}
