package com.fqg.dao;

import com.fqg.entity.TypePriceCoupon;

public interface TypePriceCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(TypePriceCoupon record);

    int insertSelective(TypePriceCoupon record);

    TypePriceCoupon selectByPrimaryKey(Integer couponId);

    int updateByPrimaryKeySelective(TypePriceCoupon record);

    int updateByPrimaryKey(TypePriceCoupon record);
}