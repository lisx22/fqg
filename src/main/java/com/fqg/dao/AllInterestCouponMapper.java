package com.fqg.dao;

import com.fqg.entity.AllInterestCoupon;

public interface AllInterestCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(AllInterestCoupon record);

    int insertSelective(AllInterestCoupon record);

    AllInterestCoupon selectByPrimaryKey(Integer couponId);

    int updateByPrimaryKeySelective(AllInterestCoupon record);

    int updateByPrimaryKey(AllInterestCoupon record);
}