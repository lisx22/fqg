package com.fqg.dao;

import com.fqg.entity.AllPriceCoupon;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface AllPriceCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(AllPriceCoupon record);

    int insertSelective(AllPriceCoupon record);

    AllPriceCoupon selectByPrimaryKey(Integer couponId);

    List<AllPriceCoupon> selectByPrice(Integer price);

    int updateByPrimaryKeySelective(AllPriceCoupon record);

    int updateByPrimaryKey(AllPriceCoupon record);

    List<AllPriceCoupon> selectAll();
}