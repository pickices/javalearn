package com.liuxinchi.springboot04shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Mycontroller {

    @RequestMapping({"/","index"})
    public String helloShiro(Model model){
        model.addAttribute("msg","hello shiro!");
        return "index";
    }

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "delete";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return  "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password );
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException ice){
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/unathc")
    @ResponseBody
    public String unathc(){
        return "你没有权限访问此页面！";
    }
}
