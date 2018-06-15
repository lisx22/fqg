package com.fqg.dao;

import com.fqg.entity.BlackCustomer;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
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