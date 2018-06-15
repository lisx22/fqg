package com.fqg.dao;

import com.fqg.entity.CommodityNoInterest;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface CommodityNoInterestMapper {
    int deleteByPrimaryKey(Integer commodityNointerestId);

    int insert(CommodityNoInterest record);

    int insertSelective(CommodityNoInterest record);

    CommodityNoInterest selectByPrimaryKey(Integer commodityNointerestId);

    int updateByPrimaryKeySelective(CommodityNoInterest record);

    int updateByPrimaryKey(CommodityNoInterest record);
}