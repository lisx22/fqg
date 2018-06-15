package com.fqg.dao;

import com.fqg.entity.TypePriceCoupon;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface TypePriceCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(TypePriceCoupon record);

    int insertSelective(TypePriceCoupon record);

    TypePriceCoupon selectByPrimaryKey(Integer couponId);

    List<TypePriceCoupon> selectByTypeId(Integer typeId);

    int updateByPrimaryKeySelective(TypePriceCoupon record);

    int updateByPrimaryKey(TypePriceCoupon record);

    List<TypePriceCoupon> selectAll();
}