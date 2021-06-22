package com.liuxinchi.service.user;

import com.liuxinchi.dao.user.UserMapper;
import com.liuxinchi.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User queryUserByCode(String userCode) {
        return userMapper.queryUserByCode(userCode);
    }

    @Override
    public User queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }

    @Override
    public User qureyUserByCodePassword(String userCode, String userPassword) {
        return userMapper.qureyUserByCodePassword(userCode,userPassword);
    }

    @Override
    public List<User> queryUserList(String userName, int userRole, int currentCount, int pageSize) {
        return userMapper.queryUserList(userName,userRole,currentCount,pageSize);
    }

    @Override
    public int queryUserCount(String userName, int userRole) {
        return userMapper.queryUserCount(userName,userRole);
    }

    @Override
    public int updateUserPassword(String userCode, String userPassword) {
        return userMapper.updateUserPassword(userCode,userPassword);
    }
}
