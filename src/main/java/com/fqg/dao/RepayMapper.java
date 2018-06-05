package com.fqg.dao;

import com.fqg.entity.Repay;

public interface RepayMapper {
    int deleteByPrimaryKey(Integer repayId);

    int insert(Repay record);

    int insertSelective(Repay record);

    Repay selectByPrimaryKey(Integer repayId);

    int updateByPrimaryKeySelective(Repay record);

    int updateByPrimaryKey(Repay record);
}