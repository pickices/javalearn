package com.liuxinchi.springboot02config;

import com.liuxinchi.springboot02config.pojo.People;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    private People people;
    @Test
    void contextLoads() {
        System.out.println(people);
    }

}
