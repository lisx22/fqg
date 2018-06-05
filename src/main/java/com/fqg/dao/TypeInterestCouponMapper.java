package com.fqg.dao;

import com.fqg.entity.TypeInterestCoupon;

public interface TypeInterestCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(TypeInterestCoupon record);

    int insertSelective(TypeInterestCoupon record);

    TypeInterestCoupon selectByPrimaryKey(Integer couponId);

    int updateByPrimaryKeySelective(TypeInterestCoupon record);

    int updateByPrimaryKey(TypeInterestCoupon record);
}