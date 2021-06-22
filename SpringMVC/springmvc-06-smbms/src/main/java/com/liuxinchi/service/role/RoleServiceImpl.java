package com.liuxinchi.service.role;

import com.liuxinchi.dao.role.RoleMapper;
import com.liuxinchi.pojo.Role;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    RoleMapper roleMapper;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> queryRoleList() {
        return roleMapper.queryRoleList();
    }
}
