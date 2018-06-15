package com.fqg.dao;

import com.fqg.entity.AllInterestCoupon;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface AllInterestCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(AllInterestCoupon record);

    int insertSelective(AllInterestCoupon record);

    AllInterestCoupon selectByPrimaryKey(Integer couponId);

    List<AllInterestCoupon> selectAll();

    int updateByPrimaryKeySelective(AllInterestCoupon record);

    int updateByPrimaryKey(AllInterestCoupon record);
}