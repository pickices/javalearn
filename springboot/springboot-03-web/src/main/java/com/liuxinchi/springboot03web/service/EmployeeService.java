package com.liuxinchi.springboot03web.service;

import com.liuxinchi.springboot03web.mapper.EmployeeMapper;
import com.liuxinchi.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper mapper;

    public void setMapper(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    public Employee queryEmployeeByEmailPwd(String email, String password){
        return mapper.queryEmployeeByEmailPwd(email,password);
    }
}
