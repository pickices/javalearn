package com.liuxinchi.service.user;

import com.liuxinchi.pojo.User;

import java.util.List;

public interface UserService {

    User userLogin(String userCode,String userPassword);

    boolean userUpdatePassword(String userCode,String newPassword);

    int queryUsersCount(String userName,int userRole);

    int queryUsersCount(String UserCode);

    int queryUsersCount(int id);

    User queryUserById(int id);

    List<User> queryUsersList(String userName, int userRole, int currentCount, int pageSize);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
