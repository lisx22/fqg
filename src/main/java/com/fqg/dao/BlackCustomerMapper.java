package com.fqg.dao;

import com.fqg.entity.BlackCustomer;

public interface BlackCustomerMapper {
    int deleteByPrimaryKey(Integer blackCustomerId);

    int insert(BlackCustomer record);

    int insertSelective(BlackCustomer record);

    BlackCustomer selectByPrimaryKey(Integer blackCustomerId);

    int updateByPrimaryKeySelective(BlackCustomer record);

    int updateByPrimaryKey(BlackCustomer record);
}