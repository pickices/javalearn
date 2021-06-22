package com.liuxinchi.demo2;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void delet() {
        System.out.println("删除了一个用户");
        
    }

    @Override
    public void qurey() {
        System.out.println("查找了一个用户");
        
    }

    @Override
    public void update() {
        System.out.println("修改了一个用户");
        
    }
    
}
