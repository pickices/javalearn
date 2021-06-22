package com.liuxinchi.configer;

import com.liuxinchi.pojo.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.liuxinchi.pojo")
public class Myconfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
