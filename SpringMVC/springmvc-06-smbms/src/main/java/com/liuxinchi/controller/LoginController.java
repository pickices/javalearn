package com.liuxinchi.controller;

import com.liuxinchi.pojo.User;
import com.liuxinchi.service.user.UserService;
import com.liuxinchi.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/tologin.do")
    public String tologin(){
        return "forward:login.jsp";
    }

    @RequestMapping("/login.do")
    public String login(String userCode, String userPassword, HttpSession httpSession, Model model){
        if(httpSession.getAttribute(Constant.USER_SESSION)!=null){
            return "frame";
        }
        User user = userService.qureyUserByCodePassword(userCode,userPassword);
        if(user==null){
            model.addAttribute("error","用户名或密码错误！");
            return "forward:/login.jsp";
        }
        httpSession.setAttribute(Constant.USER_SESSION,user);
        return "frame";
    }

    @RequestMapping("/jsp/logout.do")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute(Constant.USER_SESSION);
        return "forward:/login.jsp";
    }

}
