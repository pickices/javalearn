package com.liuxinchi.dao;

import com.liuxinchi.pojo.Bill;

import org.apache.ibatis.annotations.Param;

public interface BillMapper {
    // 根据供应商ID查询订单数量
    public int getBillCountByProviderId(@Param("providerId") Integer providerId);

    // 增加订单
    public int add(Bill bill);

    // 通过delId删除Bill
    public int deleteBillById(@Param("id") Integer delId);

    // 同通过billId获取Bill
    public Bill getBillById(@Param("id") Integer id);

    // 修改订单信息
    public int modify(Bill bill);

    // 根据供应商上ID删除订单信息
    public int deleteBillByProviderId(@Param("providerId") Integer providerId);
}
