package com.liuxinchi.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.liuxinchi.pojo.Role;
import com.liuxinchi.pojo.User;
import com.liuxinchi.service.role.RoleService;
import com.liuxinchi.service.user.UserService;
import com.liuxinchi.utils.Constant;
import com.liuxinchi.utils.PageSupport;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {

    private final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private final UserService userService = (UserService) context.getBean("userService");
    private final RoleService roleService = (RoleService) context.getBean("roleService");

    @Test
    public void myTest(){
        List<User> userList = userService.queryUsersList(null, 0, 0, 5);
        System.out.println(userList);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        switch (method){
            case "savepwd": updatePassword(req, resp);break;
            case "pwdmodify": checkOldPassword(req, resp);break;
            case "query": queryUser(req,resp);break;
            case "add": insertUser(req,resp);break;
            case "getrolelist": getRoleList(req, resp);break;
            case "ucexist": chekUserCode(req,resp);break;
            case "deluser": deleteUser(req, resp);break;
            case "view": viewUser(req, resp);break;
            case "modify": modifyViewUser(req, resp);break;
            case "modifyexe": modifyUser(req, resp);break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        String newPassword = req.getParameter("newpassword");

        if (user != null && !StringUtils.isNullOrEmpty(newPassword)) {

            if (userService.userUpdatePassword(user.getUserCode(), newPassword)) {
                req.setAttribute("message", "修改成功");
                req.getSession().removeAttribute(Constant.USER_SESSION);
            } else {
                req.setAttribute("message", "修改失败");
            }
        } else {
            req.setAttribute("message", "修改失败");
        }
        System.out.println(req.getSession().getAttribute(Constant.USER_SESSION));
        req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
    }

    protected void checkOldPassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String oldPassword = req.getParameter("oldpassword");
        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        Map<String, String> resultMap = new HashMap<>();

        if (user == null) {
            resultMap.put("result", "sessionerror");
        } else if (oldPassword == null) {
            resultMap.put("result", "error");
        } else if (!user.getUserPassword().equals(oldPassword)) {
            resultMap.put("result", "false");
        } else {
            resultMap.put("result", "true");
        }

        String result = "{\"result\":" + "\"" + resultMap.get("result") + "\"" + "}";
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    protected void queryUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;
        int currentPageNo = 1;
        int pageSize = 5;

        if(StringUtils.isNullOrEmpty(queryUserName)){
            queryUserName=null;
        }
        if(!StringUtils.isNullOrEmpty(temp)){
            queryUserRole = Integer.parseInt(temp);
        }
        if(!StringUtils.isNullOrEmpty(pageIndex)){
            currentPageNo = Integer.parseInt(pageIndex);
        }

        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(pageSize);
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setTotalCount(userService.queryUsersCount(queryUserName,queryUserRole));

        List<User> userList = userService.queryUsersList(queryUserName, queryUserRole, pageSupport.getCurrentCount(), pageSupport.getPageSize());
        List<Role> roleList = roleService.queryRolesList();

        req.setAttribute("queryname",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);
        req.setAttribute("userList",userList);
        req.setAttribute("roleList",roleList);
        req.setAttribute("currentPageNo",pageSupport.getCurrentPageNo());
        req.setAttribute("totalCount",pageSupport.getTotalCount());
        req.setAttribute("totalPageCount",pageSupport.getTotalPageCount());


        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void getRoleList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Role> roleList = roleService.queryRolesList();

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(roleList));
        writer.flush();
        writer.close();
    }

    protected void chekUserCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userCode = req.getParameter("userCode");
        int count = userService.queryUsersCount(userCode);
        Map<String,String> resultMap = new HashMap<>();

        if(count==0){
            resultMap.put("userCode","none");
        }else{
            resultMap.put("userCode","exist");
        }

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();
    }

    protected void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        User currentUser = (User) req.getSession().getAttribute(Constant.USER_SESSION);

//        req.setAttribute("roleList",roleService.queryRolesList());

        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        int gender = Integer.parseInt(req.getParameter("gender"));
        Date birthday = null;
        try {
            birthday = df.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Long userRole = Long.parseLong(req.getParameter("userRole"));
        Long createdBy = currentUser.getUserRole();
        Date creationDate = new Date();

        User user = new User(userCode,userName,userPassword,gender,birthday,phone,address,userRole,createdBy,creationDate);

        if(userService.insertUser(user)){
            resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
        }else{
            req.getRequestDispatcher("useradd.jsp").forward(req,resp);
        }
    }

    protected void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, String> resultMap = new HashMap<>();
        int id;
        id = Integer.parseInt(req.getParameter("uid"));
        System.out.println(id);
        boolean flag = userService.deleteUser(id);

        if(flag){
            resultMap.put("delResult","true");
        }else if(userService.queryUsersCount(id)==0){
            resultMap.put("delResult","notexist");
        }else {
            resultMap.put("delResult","false");
        }

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();
    }

    protected User getUserById(HttpServletRequest req, HttpServletResponse resp){
        int id;
        id = Integer.parseInt(req.getParameter("uid"));
        User user = userService.queryUserById(id);
        return user;
    }

    protected void viewUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUserById(req,resp);
        req.setAttribute("user",user);
        req.getRequestDispatcher("userview.jsp").forward(req,resp);
    }

    protected void modifyViewUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUserById(req,resp);
        req.setAttribute("user",user);
        req.getRequestDispatcher("usermodify.jsp").forward(req,resp);
    }

    protected void modifyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User sessionUser = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");

        Long id = Long.parseLong(req.getParameter("uid"));
        String userName = req.getParameter("userName");
        int gender = Integer.parseInt(req.getParameter("gender"));
        Date birthday = null;

        try {
            birthday = df.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Long userRole = Long.parseLong(req.getParameter("userRole"));
        Long modifyBy = sessionUser.getUserRole();
        Date modifyDate = new Date();

        User modifyUser = new User(id,userName,gender,birthday, phone,address,userRole,modifyBy,modifyDate);
        if(userService.updateUser(modifyUser)){
            resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
        }else {
            req.getRequestDispatcher("usermodify.jsp").forward(req,resp);
        }

    }
}
