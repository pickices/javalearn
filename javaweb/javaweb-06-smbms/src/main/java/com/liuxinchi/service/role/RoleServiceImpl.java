package com.liuxinchi.service.role;

import com.liuxinchi.dao.role.RoleDao;
import com.liuxinchi.pojo.Role;
import com.liuxinchi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Role> queryRolesList() {
        RoleDao mapper = sqlSession.getMapper(RoleDao.class);
        List<Role> roleList = mapper.queryRolesList();
        return roleList;
    }
}
