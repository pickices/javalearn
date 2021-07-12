package com.liuxinchi.service;

import com.liuxinchi.pojo.Dept;

import java.util.List;

public interface DeptService {
    Dept selectById(Long id);

    boolean addDept(Dept dept);

    List<Dept> selectAll();
}
