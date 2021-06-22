package com.liuxinchi.springboot04shiro.service;

import com.liuxinchi.springboot04shiro.pojo.User;

public interface UserService {
    User queryUserByName(String userName);
}
