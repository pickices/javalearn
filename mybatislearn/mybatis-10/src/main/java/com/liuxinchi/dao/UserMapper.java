package com.liuxinchi.dao;

import java.util.List;

import com.liuxinchi.pojo.User;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 通过userCode获取User
    public User getLoginUser(@Param("userCode") String userCode);

    // 增加用户信息
    public int add(User user);

    // 通过条件查询-userList
    public List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer userRole,
            @Param("from") Integer currentPageNo, @Param("pageSize") Integer pageSize);

    // 通过条件查询-用户表记录数
    public int getUserCount(@Param("userName") String userName, @Param("userRole") Integer userRole);

    // 通过userId删除user
    public int deleteUserById(@Param("id") Integer delId);

    // 通过userId获取user
    public User getUserById(@Param("id") Integer id);

    // 修改用户信息
    public int modify(User user);

    // 修改当前用户密码
    public int updatePwd(@Param("id") Integer id, @Param("userPassword") String pwd);
}
