package com.liuxinchi.dao;

import com.liuxinchi.dao.UserMapper;
import com.liuxinchi.pojo.User;
import com.liuxinchi.service.UserMapperImpl2;
import com.liuxinchi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void getUserList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper usermapper = context.getBean("userMapper2", UserMapper.class);
        for (User user : usermapper.getUserList()) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserList2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper usermapper = context.getBean("userMapper", UserMapper.class);
        for (User user : usermapper.getUserList()) {
            System.out.println(user);
        }
    }
}
