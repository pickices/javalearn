package com.liuxinchi.dao;

import java.util.List;

import com.liuxinchi.pojo.Provider;

import org.apache.ibatis.annotations.Param;

public interface ProviderMapper {
    // 增加用户信息
    public int add(Provider provider);

    // 通过条件查询-providerList
    public List<Provider> getProviderList(@Param("proName") String proName, @Param("proCode") String proCode,
            @Param("from") Integer currentPageNo, @Param("pageSize") Integer pageSize);

    // 获取供应商列表
    public List<Provider> getProList();

    // 通过条件查询-供应商表记录数
    public int getProviderCount(@Param("proName") String proName, @Param("proCode") String proCode);

    // 通过供应商ID删除供应商信息
    public int deleteProviderById(@Param("id") Integer delId);

    // 根据provider id获取供应商信息
    public Provider getProviderById(@Param("id") Integer id);

    // 修改供应商
    public int modify(Provider provider);
}
