package com.liuxinchi.dao;

import java.util.HashMap;
import java.util.List;

import com.liuxinchi.pojo.User;
import com.liuxinchi.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for(User user:userList){
            System.out.println(user);
        }
        sqlsession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> userlist = mapper.getUserLike("liuxin");
        for (User user : userlist) {
            System.out.println(user);
        }
        sqlsession.close();
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        
        List<User> userlist = mapper.getUserByLimit(map);
        for (User user : userlist) {
            System.out.println(user);
        }
        
        sqlsession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
        sqlsession.close();
    }

    @Test
    public void getUserByName(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserByName(1, "liuxinchi");
        System.out.println(user);
        sqlsession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.addUser(new User(4,"liuxinyu","123456"));
        List<User> userList = mapper.getUserList();
        for(User user:userList){
            System.out.println(user);
        }
        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void updataUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.updataUser(new User(2,"zhaocheng","123456"));
        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void deletUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.deletUser(4);
        sqlsession.commit();
        sqlsession.close();
    }

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testlog4j(){
        logger.info("info:?????????testlog4j");
        logger.debug("debug:?????????testlog4j");
        logger.error("error:?????????testlog4j");
    }
}
