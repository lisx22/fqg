package com.fqg.dao;

import com.fqg.entity.TypeOne;
import com.fqg.entity.TypeTwo;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface TypeTwoMapper {
    int deleteByPrimaryKey(Integer typeTwoId);

    int insert(TypeTwo record);

    int insertSelective(TypeTwo record);

    TypeTwo selectByPrimaryKey(Integer typeTwoId);

    int updateByPrimaryKeySelective(TypeTwo record);

    int updateByPrimaryKey(TypeTwo record);

    List<TypeTwo> selectByTypeOne(Integer typeOneId);

    List<TypeOne> selectAll();
}