package com.fqg.dao;

import com.fqg.entity.CommodityLabel;

public interface CommodityLabelMapper {
    int deleteByPrimaryKey(Integer commodityLabelId);

    int insert(CommodityLabel record);

    int insertSelective(CommodityLabel record);

    CommodityLabel selectByPrimaryKey(Integer commodityLabelId);

    int updateByPrimaryKeySelective(CommodityLabel record);

    int updateByPrimaryKey(CommodityLabel record);
}