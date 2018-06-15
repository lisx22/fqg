package com.fqg.dao;

import com.fqg.entity.CommodityLabel;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface CommodityLabelMapper {
    int deleteByPrimaryKey(Integer commodityLabelId);

    int insert(CommodityLabel record);

    int insertSelective(CommodityLabel record);

    CommodityLabel selectByPrimaryKey(Integer commodityLabelId);

    int updateByPrimaryKeySelective(CommodityLabel record);

    int updateByPrimaryKey(CommodityLabel record);
}