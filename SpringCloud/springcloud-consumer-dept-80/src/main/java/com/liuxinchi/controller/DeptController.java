package com.liuxinchi.controller;

import com.liuxinchi.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController {

    @Autowired
    RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";
    private static final String REST_URL_PREFIX = "http://PROVIDER-DEPT";
    private static final String REST_URL_MAPPING = "/dept";

    @GetMapping("/select/{id}")
    public Dept selectById(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+REST_URL_MAPPING+"/select/"+id,Dept.class);
    }

    @GetMapping("/selectAll")
    public List<DebugGraphics> selectAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+REST_URL_MAPPING+"/selectAll",List.class);
    }

    @RequestMapping("/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+REST_URL_MAPPING+"/add",dept,Boolean.class);
    }
}
