package com.liuxinchi.dao;

import java.util.List;

import com.liuxinchi.pojo.Student;
import com.liuxinchi.pojo.Teacher;
import com.liuxinchi.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Mytest {
    
    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close(); 
    }

    @Test
    public void getstudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close(); 
    }

    @Test
    public void getstudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close(); 
    }
}
