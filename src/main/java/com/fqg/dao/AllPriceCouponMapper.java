package com.fqg.dao;

import com.fqg.entity.AllPriceCoupon;

public interface AllPriceCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(AllPriceCoupon record);

    int insertSelective(AllPriceCoupon record);

    AllPriceCoupon selectByPrimaryKey(Integer couponId);

    int updateByPrimaryKeySelective(AllPriceCoupon record);

    int updateByPrimaryKey(AllPriceCoupon record);
}