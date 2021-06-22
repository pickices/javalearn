package com.liuxinchi;

import com.liuxinchi.dao.UserMapper;
import com.liuxinchi.pojo.User;
import com.liuxinchi.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    
    @Test
    public void getUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUser(1);
        System.out.println(user);
        sqlsession.close();
        System.out.println("===========================================");
        SqlSession sqlsession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlsession2.getMapper(UserMapper.class);
        User user2 = mapper2.getUser(1);
        System.out.println(user2);
        sqlsession2.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.updateUser(new User(2,"zhangsan","123456"));
        sqlsession.close();
    }

    @Test
    public void sad(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.close();
    }
}
