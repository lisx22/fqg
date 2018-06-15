package com.fqg.dao;

import com.fqg.entity.CommodityInterest;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface CommodityInterestMapper {
    int deleteByPrimaryKey(Integer commodityInterestId);

    int insert(CommodityInterest record);

    int insertSelective(CommodityInterest record);

    CommodityInterest selectByPrimaryKey(Integer commodityInterestId);

    int updateByPrimaryKeySelective(CommodityInterest record);

    int updateByPrimaryKey(CommodityInterest record);
}