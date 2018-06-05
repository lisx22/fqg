package com.fqg.dao;

import com.fqg.entity.TypeThree;

public interface TypeThreeMapper {
    int deleteByPrimaryKey(Integer typeThreeId);

    int insert(TypeThree record);

    int insertSelective(TypeThree record);

    TypeThree selectByPrimaryKey(Integer typeThreeId);

    int updateByPrimaryKeySelective(TypeThree record);

    int updateByPrimaryKey(TypeThree record);
}