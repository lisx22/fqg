package com.fqg.dao;

import com.fqg.entity.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    /**
     * 通过主键查询真实姓名
     * @param customerId
     * @return
     */
    String selectTrueNameById(Integer customerId);
}