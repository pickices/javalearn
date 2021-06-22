package com.liuxinchi.springboot05swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SwaggerController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
