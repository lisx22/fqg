package com.fqg.dao;

import com.fqg.entity.AllPriceCoupon;

import java.util.List;

public interface AllPriceCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(AllPriceCoupon record);

    int insertSelective(AllPriceCoupon record);

    AllPriceCoupon selectByPrimaryKey(Integer couponId);

    List<AllPriceCoupon> selectByPrice(Integer price);

    int updateByPrimaryKeySelective(AllPriceCoupon record);

    int updateByPrimaryKey(AllPriceCoupon record);
}