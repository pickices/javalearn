package com.liuxinchi.springboot03web.mapper;

import com.liuxinchi.springboot03web.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EmployeeMapper {
    Employee queryEmployeeByEmailPwd(@Param("email") String email,@Param("password")String password);
}
