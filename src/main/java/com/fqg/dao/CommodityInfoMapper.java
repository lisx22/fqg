package com.fqg.dao;

import com.fqg.entity.CommodityInfo;

public interface CommodityInfoMapper {
    int deleteByPrimaryKey(Integer commodityInfoId);

    int insert(CommodityInfo record);

    int insertSelective(CommodityInfo record);

    CommodityInfo selectByPrimaryKey(Integer commodityInfoId);

    int updateByPrimaryKeySelective(CommodityInfo record);

    int updateByPrimaryKey(CommodityInfo record);
}