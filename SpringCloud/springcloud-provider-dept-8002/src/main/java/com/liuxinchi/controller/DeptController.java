package com.liuxinchi.controller;

import com.liuxinchi.pojo.Dept;
import com.liuxinchi.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @PostMapping("/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/select/{id}")
    public Dept selectById(@PathVariable("id") Long id){
        return deptService.selectById(id);
    }

    @GetMapping("/selectAll")
    public List<Dept> selectAll(){
        return deptService.selectAll();
    }
}
