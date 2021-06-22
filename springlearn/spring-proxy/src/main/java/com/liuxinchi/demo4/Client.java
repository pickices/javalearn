package com.liuxinchi.demo4;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userserviceimp = new UserServiceImpl();
        UserServiceProxy usp = new UserServiceProxy();
        usp.setTarget(userserviceimp);
        UserService userservice = (UserService)usp.getProxy();
        userservice.add();
    }
}
