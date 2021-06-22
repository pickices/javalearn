package com.liuxinchi.controller.user;

import com.liuxinchi.pojo.Role;
import com.liuxinchi.pojo.User;
import com.liuxinchi.service.role.RoleService;
import com.liuxinchi.service.user.UserService;
import com.liuxinchi.utils.Constant;
import com.liuxinchi.utils.pageUtils;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/jsp/user.do")
    public String userdo(HttpServletRequest request) {
        String method = request.getParameter("method");
        switch (method){
            case "pwdmodify": return "forward:oldpwdcheck.do";
            case "savepwd": return "forward:pwdmodifyexec.do";
            case "query": return "forward:touserpage.do";
            case "queryrolelist":return "forward:queryrolelist.do";
            case "add" : return "";
        }
        return null;
    }

    @RequestMapping("/jsp/topwdmodify.do")
    public String toPwdmodify(){
        return "pwdmodify";
    }

    @RequestMapping("/jsp/touserpage.do")
    public String toUserPage(HttpServletRequest request,Model model){
        pageUtils page = new pageUtils();
        String pageIndex = request.getParameter("pageIndex");
        System.out.println(pageIndex);

        if(StringUtils.isNullOrEmpty(pageIndex)){
            page.setCurrentPage(1);
        }else {
            page.setCurrentPage(Integer.parseInt(pageIndex));
        }

        int queryUserRoleInt = 0;
        String queryUserName = request.getParameter("queryname");
        String queryuserRoleString = request.getParameter("queryUserRole");

        if(StringUtils.isNullOrEmpty(queryUserName)){
            queryUserName = null;
        }
        if(!StringUtils.isNullOrEmpty(queryuserRoleString)){
            queryUserRoleInt = Integer.parseInt(queryuserRoleString);
        }

        page.setTotalCount(userService.queryUserCount(queryUserName,queryUserRoleInt));

        model.addAttribute("queryname",queryUserName);
        model.addAttribute(("queryUserRole"),queryUserRoleInt);
        model.addAttribute("userList",userService.queryUserList(queryUserName,queryUserRoleInt,page.getCurrentCount(),Constant.PAGE_SIZE));
        model.addAttribute("totalCount",page.getTotalCount());
        model.addAttribute("currentPageNo",page.getCurrentPage());
        model.addAttribute("totalPageCount",page.getTotalPage());
        model.addAttribute("roleList",roleService.queryRoleList());

        return "userlist";
    }

    @RequestMapping("jsp/touseradd.do")
    public String toUserAdd(Model model){
//        model.addAttribute("roleList",roleService.queryRoleList());
        return "useradd";
    }

    @ResponseBody
    @RequestMapping("/jsp/queryrolelist.do")
    public List<Role> queryRoleList(){
        System.out.println("进入了查询角色方法");
        List<Role> roleList = roleService.queryRoleList();
        System.out.println(roleList.get(1));
        return  roleList;
    }

    @ResponseBody
    @RequestMapping("/jsp/oldpwdcheck.do")
    public Map<String, String> oldPwdCheck(@RequestParam("oldpassword") String oldPassword, HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Constant.USER_SESSION);
        Map<String, String> result = new HashMap<>();
        if(user==null){
            result.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldPassword)){
            result.put("result","error");
        }else if(!oldPassword.equals(user.getUserPassword())){
            result.put("result","false");
        }else {
            result.put("result","true");
        }
        return result;
    }

    @RequestMapping(value = "/jsp/pwdmodifyexec.do",method = RequestMethod.POST)
    public String pwdModifyEexc(@RequestParam("newpassword") String newPassword,HttpSession httpSession,Model model){
        User user = (User) httpSession.getAttribute(Constant.USER_SESSION);
        int isSuccess = userService.updateUserPassword(user.getUserCode(), newPassword);
        if(isSuccess>0) {
            model.addAttribute("message","密码修改成功!");
            User newuser = (User) httpSession.getAttribute(Constant.USER_SESSION);
            newuser.setUserPassword(newPassword);
            httpSession.setAttribute(Constant.USER_SESSION,newuser);
        }
        else{
            model.addAttribute("meeage","密码修改失败！");
        }
        return "forward:topwdmodify.do";
    }

//    @RequestMapping(value = "/jsp/useradd.do",method = RequestMethod.POST)
//    public String userAdd(User user){
//
//    }

}
