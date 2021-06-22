package com.liuxinchi.springboot04shiro.service;

import com.liuxinchi.springboot04shiro.mapper.UserMapper;
import com.liuxinchi.springboot04shiro.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }
}
