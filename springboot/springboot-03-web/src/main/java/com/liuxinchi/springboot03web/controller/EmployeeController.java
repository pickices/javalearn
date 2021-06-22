package com.liuxinchi.springboot03web.controller;

import com.liuxinchi.springboot03web.pojo.Employee;
import com.liuxinchi.springboot03web.service.EmployeeService;
import com.liuxinchi.springboot03web.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/login")
    public String LoginMain(@RequestParam("email")String email, @RequestParam("password")String password, Model model, HttpSession httpSession){
        Employee employee = employeeService.queryEmployeeByEmailPwd(email, password);
        if(employee!=null){
            httpSession.setAttribute(Constant.EMPLOYEE_SESSION,employee);
            return "redirect:/main";
        }
        model.addAttribute("msg","用户名或密码错误！");
        return "index";
    }
}
