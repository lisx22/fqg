package com.fqg.dao;

import com.fqg.entity.CommodityColor;

import java.util.List;

public interface CommodityColorMapper {
    int deleteByPrimaryKey(Integer commodityColorId);

    int insert(CommodityColor record);

    int insertSelective(CommodityColor record);

    List<CommodityColor> selectByCommodityId(Integer commodityId);

    int updateByPrimaryKeySelective(CommodityColor record);

    int updateByPrimaryKey(CommodityColor record);
}