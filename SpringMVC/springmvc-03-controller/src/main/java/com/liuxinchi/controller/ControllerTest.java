package com.liuxinchi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

    @RequestMapping("/dispatcher")
    public String dispatcher(Model model){
        model.addAttribute("msg","转发成功");
        return "hello";
    }

    @RequestMapping("/redirect")
    public String Redirect(Model model){
        model.addAttribute("msg","重定向成功");
        return "redirect:/index.jsp";
    }
}
