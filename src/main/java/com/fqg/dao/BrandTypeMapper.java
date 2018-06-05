package com.fqg.dao;

import com.fqg.entity.BrandType;

public interface BrandTypeMapper {
    int deleteByPrimaryKey(Integer brandTypeId);

    int insert(BrandType record);

    int insertSelective(BrandType record);

    BrandType selectByPrimaryKey(Integer brandTypeId);

    int updateByPrimaryKeySelective(BrandType record);

    int updateByPrimaryKey(BrandType record);
}