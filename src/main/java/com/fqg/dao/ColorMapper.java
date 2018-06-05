package com.fqg.dao;

import com.fqg.entity.Color;

import java.util.List;

public interface ColorMapper {
    int deleteByPrimaryKey(Integer colorId);

    int insert(Color record);

    int insertSelective(Color record);

    Color selectByPrimaryKey(Integer colorId);

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);

    /**
     * 通过商品ID查询颜色集合
     * @param commodityId
     * @return
     */
    List<Color> selectColorListByCommodityId(Integer commodityId);
}