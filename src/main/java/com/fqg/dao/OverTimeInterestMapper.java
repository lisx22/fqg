package com.fqg.dao;

import com.fqg.entity.OverTimeInterest;

public interface OverTimeInterestMapper {
    int deleteByPrimaryKey(Double outtimeInterest);

    int insert(OverTimeInterest record);

    int insertSelective(OverTimeInterest record);
}