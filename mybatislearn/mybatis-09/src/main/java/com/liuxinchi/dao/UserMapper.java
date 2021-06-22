package com.liuxinchi.dao;

import com.liuxinchi.pojo.User;

public interface UserMapper {
    User getUser(int id);
    int updateUser(User user);
}
