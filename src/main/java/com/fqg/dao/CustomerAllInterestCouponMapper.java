package com.fqg.dao;

import com.fqg.entity.CustomerAllInterestCoupon;

public interface CustomerAllInterestCouponMapper {
    int deleteByPrimaryKey(Integer customerCouponId);

    int insert(CustomerAllInterestCoupon record);

    int insertSelective(CustomerAllInterestCoupon record);

    CustomerAllInterestCoupon selectByPrimaryKey(Integer customerCouponId);

    int updateByPrimaryKeySelective(CustomerAllInterestCoupon record);

    int updateByPrimaryKey(CustomerAllInterestCoupon record);
}