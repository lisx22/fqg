package com.fqg.dao;

import com.fqg.entity.CustomerPriceCoupon;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface CustomerPriceCouponMapper {
    int deleteByPrimaryKey(Integer customerCouponId);

    int insert(CustomerPriceCoupon record);

    int insertSelective(CustomerPriceCoupon record);

    CustomerPriceCoupon selectByPrimaryKey(Integer customerCouponId);

    int updateByPrimaryKeySelective(CustomerPriceCoupon record);

    int updateByPrimaryKey(CustomerPriceCoupon record);
}