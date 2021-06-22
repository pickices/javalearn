package com.liuxinchi.dao;

import java.util.List;

import com.liuxinchi.pojo.User;
import com.liuxinchi.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    
    @Test
    public void getLoginUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getLoginUser("zhangchen");
        System.out.println(user);
        sqlsession.close();
    }

    @Test
    public void add(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        java.util.Date date = new java.util.Date();
        java.sql.Date current_date = new java.sql.Date(date.getTime());
        User user = new User((long)16,"liuxinchi","柳鑫驰","592295lxc",1,current_date,"18283009866","chongqing",1,(long)1,current_date,(long)1,current_date);
        mapper.add(user);
        sqlsession.commit();
        sqlsession.close();
    }

    @Test 
    public void getUserList(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> userlist = mapper.getUserList("孙",3,0,13);
        for (User user : userlist) {
            System.out.println(user);
        }
        sqlsession.close();
    }

    @Test
    public void getUserCount(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        System.out.println(mapper.getUserCount("孙兴",3));
        sqlsession.close();
    }

    @Test
    public void deleteUserById(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.deleteUserById(16);
        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void modify(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        java.util.Date date = new java.util.Date();
        java.sql.Date current_date = new java.sql.Date(date.getTime());
        User user = new User((long)16,"liuxinchi","柳鑫驰","123456",1,current_date,"18283009866","chongqing",1,(long)1,current_date,(long)1,current_date);
        mapper.modify(user);
        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void updatePwd(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.updatePwd(16, "000000");
        sqlsession.commit();
        sqlsession.close();
    }
    
}
