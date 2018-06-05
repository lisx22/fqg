package com.fqg.dao;

import com.fqg.entity.CustomerPriceCoupon;

public interface CustomerPriceCouponMapper {
    int deleteByPrimaryKey(Integer customerCouponId);

    int insert(CustomerPriceCoupon record);

    int insertSelective(CustomerPriceCoupon record);

    CustomerPriceCoupon selectByPrimaryKey(Integer customerCouponId);

    int updateByPrimaryKeySelective(CustomerPriceCoupon record);

    int updateByPrimaryKey(CustomerPriceCoupon record);
}