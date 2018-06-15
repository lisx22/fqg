package com.fqg.dao;

import com.fqg.entity.TypeInterestCoupon;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface TypeInterestCouponMapper {
    int deleteByPrimaryKey(Integer couponId);

    int insert(TypeInterestCoupon record);

    int insertSelective(TypeInterestCoupon record);

    TypeInterestCoupon selectByPrimaryKey(Integer couponId);

    List<TypeInterestCoupon> selectByTypeId(Integer typeId);

    int updateByPrimaryKeySelective(TypeInterestCoupon record);

    int updateByPrimaryKey(TypeInterestCoupon record);

    List<TypeInterestCoupon> selectAll();
}