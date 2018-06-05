package com.fqg.dao;

import com.fqg.entity.CommodityColor;

public interface CommodityColorMapper {
    int deleteByPrimaryKey(Integer commodityColorId);

    int insert(CommodityColor record);

    int insertSelective(CommodityColor record);

    CommodityColor selectByPrimaryKey(Integer commodityColorId);

    int updateByPrimaryKeySelective(CommodityColor record);

    int updateByPrimaryKey(CommodityColor record);
}