package com.liuxinchi.dao;

import com.liuxinchi.pojo.Teacher;
import com.liuxinchi.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Mytest {
    @Test
    public void getTeacher(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
    }

    @Test
    public void getTeacher2(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
    }
}
