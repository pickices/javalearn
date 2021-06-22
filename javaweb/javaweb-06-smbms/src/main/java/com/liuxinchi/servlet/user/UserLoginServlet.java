package com.liuxinchi.servlet.user;

import com.liuxinchi.pojo.User;
import com.liuxinchi.service.user.UserService;
import com.liuxinchi.service.user.UserServiceImpl;
import com.liuxinchi.utils.Constant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        User user = userService.userLogin(userCode,userPassword);
        if(user!=null){
            req.getSession().setAttribute(Constant.USER_SESSION,user);
            resp.sendRedirect("jsp/frame.jsp");
        }
        else{
            req.getSession().setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
