package com.fqg.dao;

import com.fqg.entity.BlackCustomer;
import com.fqg.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlackCustomerMapper {
    int deleteByPrimaryKey(Integer blackCustomerId);

    int insert(BlackCustomer record);

    int insertSelective(BlackCustomer record);

    BlackCustomer selectByPrimaryKey(Integer blackCustomerId);

    int updateByPrimaryKeySelective(BlackCustomer record);

    int updateByPrimaryKey(BlackCustomer record);

    List<BlackCustomer> selectByPage(@Param("first")int first, @Param("pageSize")int pageSize);

    int selectCount();

    List<BlackCustomer> selectByID(String idNumber);
}