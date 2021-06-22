package com.liuxinchi.dao.user;

import com.liuxinchi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User queryUserByCode(@Param("userCode") String userCode);

    User queryUserByName(@Param("userName") String userName);

    User qureyUserByCodePassword(@Param("userCode") String userCode,@Param("userPassword") String userPassword);

    List<User> queryUserList(@Param("userName") String userName,@Param("userRole") int userRole,@Param("currentCount")int currentCount,@Param("pageSize")int pageSize);

    int queryUserCount(@Param("userName") String userName,@Param("userRole") int userRole);

    int updateUserPassword(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
}
