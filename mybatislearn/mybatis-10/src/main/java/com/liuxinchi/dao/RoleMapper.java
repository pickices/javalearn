package com.liuxinchi.dao;

import java.util.List;

import com.liuxinchi.pojo.Role;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    // 获取角色列表
    public List<Role> getRoleList();

    // 增加角色信息
    public int add(Role role);

    // 通过ID删除role
    public int deleteRoleById(@Param("id") Integer delId);

    // 修改角色信息
    public int modify(Role role);

    // 通过Id获取role
    public Role getRoleById(@Param("id") Integer id);

    // 根据RoleCode，进行角色编码得唯一性验证
    public int roleCodeIsExist(@Param("roleCode") String roleCode);
}
