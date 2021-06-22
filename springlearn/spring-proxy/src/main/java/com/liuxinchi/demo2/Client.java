package com.liuxinchi.demo2;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userservice = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUservice(userservice);
        proxy.add();
    }
}
