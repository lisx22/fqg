package com.fqg.dao;

import com.fqg.entity.TypeOne;
import com.fqg.entity.TypeThree;

import java.util.List;

public interface TypeThreeMapper {
    int deleteByPrimaryKey(Integer typeThreeId);

    int insert(TypeThree record);

    int insertSelective(TypeThree record);

    TypeThree selectByPrimaryKey(Integer typeThreeId);

    int updateByPrimaryKeySelective(TypeThree record);

    int updateByPrimaryKey(TypeThree record);

    List<TypeThree> selectByTypeTwo(Integer typeTwoId);

    List<TypeOne> selectAll();
}