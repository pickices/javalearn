package com.liuxinchi.dao;

import com.liuxinchi.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeptMapper {

    Dept selectById(Long id);

    Integer addDept(Dept dept);

    List<Dept> selectAll();

}
