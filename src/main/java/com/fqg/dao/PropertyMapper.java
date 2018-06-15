package com.fqg.dao;

import com.fqg.entity.Property;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface PropertyMapper {
    int deleteByPrimaryKey(Integer propertyId);

    int insert(Property record);

    int insertSelective(Property record);

    Property selectByPrimaryKey(Integer propertyId);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}