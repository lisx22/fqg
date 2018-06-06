package com.fqg.dao;

import com.fqg.entity.AllInterestCoupon;

import java.util.List;

public interface AllInterestCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(AllInterestCoupon record);

    int insertSelective(AllInterestCoupon record);

    AllInterestCoupon selectByPrimaryKey(Integer couponId);

    List<AllInterestCoupon> selectAll();

    int updateByPrimaryKeySelective(AllInterestCoupon record);

    int updateByPrimaryKey(AllInterestCoupon record);
}