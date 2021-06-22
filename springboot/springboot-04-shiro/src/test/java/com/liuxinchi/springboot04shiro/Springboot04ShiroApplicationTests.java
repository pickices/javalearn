package com.liuxinchi.springboot04shiro;

import com.liuxinchi.springboot04shiro.service.UserService;
import com.liuxinchi.springboot04shiro.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot04ShiroApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("liuxinchi"));
    }

}
