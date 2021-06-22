package com.liuxinchi.springboot04shiro.mapper;

import com.liuxinchi.springboot04shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
     User queryUserByName(String userName);
}
