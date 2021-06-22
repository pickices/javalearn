package com.liuxinchi.dao;

import com.liuxinchi.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    int adduser(User user);
    int deleteuser(int id);
}
