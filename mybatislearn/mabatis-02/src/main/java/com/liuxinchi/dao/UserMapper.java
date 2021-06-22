package com.liuxinchi.dao;

import java.util.List;

import com.liuxinchi.pojo.User;

public interface UserMapper {
    List<User> getUserList();
    List<User> getUserLike(String value);
    User getUserById(int id);
    int addUser(User user);
    int updataUser(User user);
    int deletUser(int id);
}
