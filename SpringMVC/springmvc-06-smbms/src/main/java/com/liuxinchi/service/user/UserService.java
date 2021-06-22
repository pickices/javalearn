package com.liuxinchi.service.user;

import com.liuxinchi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    User queryUserByCode(String userCode);

    User queryUserByName(String userName);

    User qureyUserByCodePassword(String userCode, String userPassword);

    List<User> queryUserList(String userName, int userRole,int currentCount,int pageSize);

    int queryUserCount(String userName, int userRole);

    int updateUserPassword(String userCode,String userPassword);
}
