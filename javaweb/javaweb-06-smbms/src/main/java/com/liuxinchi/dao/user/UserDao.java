package com.liuxinchi.dao.user;

import com.liuxinchi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User userLogin(@Param("userCode") String userCode, @Param("userPassword") String userPassword);

    int userUpdatePassword(@Param("userCode") String userCode, @Param("userPassword") String userPassword);

    int queryUsersCount(@Param("userName")String userName,@Param("userRole")int userRole);

    int queryUsersCountByCode(@Param("userCode")String userCode);

    int queryUsersCountById(@Param("id")int id);

    User queryUserById(int id);

    List<User> queryUsersList(@Param("userName")String userName,@Param("userRole")int userRole,@Param("currentCount")int currentCount,@Param("pageSize")int pageSize);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
