package com.liuxinchi.springboot04shiro.config;

import com.liuxinchi.springboot04shiro.pojo.User;
import com.liuxinchi.springboot04shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        info.addStringPermission(user.getPerms());

        System.out.println("执行了授权方法");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证方法");
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;

        User user = userService.queryUserByName(token1.getUsername());

        if(user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
