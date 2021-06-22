package com.liuxinchi.dao;

import java.util.List;
import java.util.Map;

import com.liuxinchi.pojo.Blog;

public interface BlogMapper {
    int addBlog(Blog blog);
    List<Blog> getBlogIf(Map map);
    List<Blog> getBlogChoose(Map map);
    List<Blog> getBlogForeach(List ids);
    int updateBlog(Map map);
}
