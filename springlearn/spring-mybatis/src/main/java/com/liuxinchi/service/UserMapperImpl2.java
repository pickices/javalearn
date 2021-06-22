package com.liuxinchi.service;

import com.liuxinchi.dao.UserMapper;
import com.liuxinchi.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getUserList() {
        return getSqlSession().getMapper(UserMapper.class).getUserList();
    }
}
