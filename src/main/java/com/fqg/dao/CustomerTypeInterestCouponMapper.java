package com.fqg.dao;

import com.fqg.entity.CustomerTypeInterestCoupon;

public interface CustomerTypeInterestCouponMapper {
    int deleteByPrimaryKey(Integer customerCouponId);

    int insert(CustomerTypeInterestCoupon record);

    int insertSelective(CustomerTypeInterestCoupon record);

    CustomerTypeInterestCoupon selectByPrimaryKey(Integer customerCouponId);

    int updateByPrimaryKeySelective(CustomerTypeInterestCoupon record);

    int updateByPrimaryKey(CustomerTypeInterestCoupon record);
}