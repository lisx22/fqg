package com.fqg.dao;

import com.fqg.entity.NoInterest;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface NoInterestMapper {
    int deleteByPrimaryKey(Integer nointerestId);

    int insert(NoInterest record);

    int insertSelective(NoInterest record);

    NoInterest selectByPrimaryKey(Integer nointerestId);

    int updateByPrimaryKeySelective(NoInterest record);

    int updateByPrimaryKey(NoInterest record);
}