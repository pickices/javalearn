package com.liuxinchi.dao;

import java.util.List;

import com.liuxinchi.pojo.User;
import com.liuxinchi.utils.MybatisUtils;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void getUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // List<User> userList = mapper.getUsers();
        // for (User user : userList) {
        // System.out.println(user);
        // }

        // 查询用户
        // User user = mapper.getUserById(1, "liuxinchi");
        // System.out.println(user);
        // 增加用户
        // mapper.addUser(new User(6,"wuqilong","1234232"));
        // 修改用户
        // mapper.updateUser(new User(6,"fenghaoxiang","88888"));
        // 删除用户
        mapper.delete(6);
        sqlSession.close();

    }
}
