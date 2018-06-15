package com.fqg.dao;

import com.fqg.entity.CommodityColor;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface CommodityColorMapper {
    int deleteByPrimaryKey(Integer commodityColorId);

    int insert(CommodityColor record);

    int insertSelective(CommodityColor record);

    int updateByPrimaryKeySelective(CommodityColor record);

    int updateByPrimaryKey(CommodityColor record);

    List<CommodityColor> selectCCListByCommodityId(Integer commodityId);

    Integer selectPriceByCommodityIdAndColorId(
            @Param("commodityId") Integer commodityId,
            @Param("colorId") Integer colorId
    );
}