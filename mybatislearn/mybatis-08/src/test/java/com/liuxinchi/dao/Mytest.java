package com.liuxinchi.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liuxinchi.pojo.Blog;
import com.liuxinchi.utils.IdUtils;
import com.liuxinchi.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Mytest {
    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreate_time(new Date());
        blog.setViews(9999);
    
        mapper.addBlog(blog);
    
        blog.setId(IdUtils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);
    
        blog.setId(IdUtils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);
    
        blog.setId(IdUtils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);
    
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBlogIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("author", "狂神");
        List<Blog> blogList = mapper.getBlogChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Test
    public void getBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title", "JAVA02");
        map.put("views", 2000);
        map.put("id", "bcc4a19bf6a24b7d938bea601fd09ee8");
        List<Blog> blogList = mapper.getBlogChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Blog> blogList = mapper.getBlogForeach(ids);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    
    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title", "JAVA02");
        map.put("views", 2000);
        map.put("id", "bcc4a19bf6a24b7d938bea601fd09ee8");
        mapper.updateBlog(map);
        sqlSession.commit();
        sqlSession.close();
    }

}
