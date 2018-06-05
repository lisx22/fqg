package com.fqg.dao;

import com.fqg.entity.CustomerTypePriceCoupon;

public interface CustomerTypePriceCouponMapper {
    int deleteByPrimaryKey(Integer customerCouponId);

    int insert(CustomerTypePriceCoupon record);

    int insertSelective(CustomerTypePriceCoupon record);

    CustomerTypePriceCoupon selectByPrimaryKey(Integer customerCouponId);

    int updateByPrimaryKeySelective(CustomerTypePriceCoupon record);

    int updateByPrimaryKey(CustomerTypePriceCoupon record);
}