package com.fqg.dao;

import com.fqg.entity.BuyInterest;

public interface BuyInterestMapper {
    int deleteByPrimaryKey(Integer interestId);

    int insert(BuyInterest record);

    int insertSelective(BuyInterest record);

    BuyInterest selectByPrimaryKey(Integer interestId);

    int updateByPrimaryKeySelective(BuyInterest record);

    int updateByPrimaryKey(BuyInterest record);
}