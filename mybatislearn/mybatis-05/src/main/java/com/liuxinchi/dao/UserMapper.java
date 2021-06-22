package com.liuxinchi.dao;

import java.util.List;

import com.liuxinchi.pojo.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    @Select("select *from user where id = #{id}")
    User getUserById(@Param("id") int id, @Param("name")String name);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int delete(@Param("uid") int id);

}
