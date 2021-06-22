package com.liuxinchi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuxinchi.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JsonTest01 {

    @RequestMapping(value = "/j1")
    public String j1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("柳鑫驰",24,"男");
        String s = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping(value = "/j2")
    public String j2() throws JsonProcessingException {
        List<User> userList = new ArrayList<>();
        User user1 = new User("柳鑫驰1",24,"男");
        User user2 = new User("柳鑫驰2",24,"男");
        User user3 = new User("柳鑫驰3",24,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return new ObjectMapper().writeValueAsString(userList);
    }


}
