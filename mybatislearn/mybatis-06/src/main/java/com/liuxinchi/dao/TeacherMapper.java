package com.liuxinchi.dao;

import com.liuxinchi.pojo.Teacher;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    
    @Select("select * from mybatis.teacher where id = #{uid}")
    Teacher getTeacher(@Param("uid") int id);
}
