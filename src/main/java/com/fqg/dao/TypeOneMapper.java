package com.fqg.dao;

import com.fqg.entity.TypeOne;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface TypeOneMapper {
    int deleteByPrimaryKey(Integer typeOneId);

    int insert(TypeOne record);

    int insertSelective(TypeOne record);

    TypeOne selectByPrimaryKey(Integer typeOneId);

    int updateByPrimaryKeySelective(TypeOne record);

    int updateByPrimaryKey(TypeOne record);

    List<TypeOne> selectAll();
}