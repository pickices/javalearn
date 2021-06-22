package com.liuxinchi.service;

import com.liuxinchi.dao.UserMapper;
import com.liuxinchi.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public List<User> getUserList() {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        mapper.adduser(new User(7,"小李","353425"));
        mapper.deleteuser(7);
        return mapper.getUserList();
    }

    @Override
    public int adduser(User user) {
        return getSqlSession().getMapper(UserMapper.class).adduser(user);
    }

    @Override
    public int deleteuser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteuser(id);
    }


}
