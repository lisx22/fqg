package com.fqg.dao;

import com.fqg.entity.CustomerTypePriceCoupon;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface CustomerTypePriceCouponMapper {
    int deleteByPrimaryKey(Integer customerCouponId);

    int insert(CustomerTypePriceCoupon record);

    int insertSelective(CustomerTypePriceCoupon record);

    CustomerTypePriceCoupon selectByPrimaryKey(Integer customerCouponId);

    int updateByPrimaryKeySelective(CustomerTypePriceCoupon record);

    int updateByPrimaryKey(CustomerTypePriceCoupon record);
}