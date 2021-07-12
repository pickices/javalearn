package com.liuxinchi.service;

import com.liuxinchi.dao.DeptMapper;
import com.liuxinchi.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    DeptMapper deptMapper;

    @Override
    public Dept selectById(Long id) {
        return deptMapper.selectById(id);
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept).equals(1);
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }

}
