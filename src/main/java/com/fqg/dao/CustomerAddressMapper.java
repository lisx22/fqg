package com.fqg.dao;

import com.fqg.entity.CustomerAddress;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface CustomerAddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(CustomerAddress record);

    int insertSelective(CustomerAddress record);

    CustomerAddress selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(CustomerAddress record);

    int updateByPrimaryKey(CustomerAddress record);
}