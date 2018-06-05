package com.fqg.dao;

import com.fqg.entity.CommodityInfoImage;

import java.util.List;

public interface CommodityInfoImageMapper {
    int deleteByPrimaryKey(Integer infoImageId);

    int insert(CommodityInfoImage record);

    int insertSelective(CommodityInfoImage record);

    CommodityInfoImage selectByPrimaryKey(Integer infoImageId);

    int updateByPrimaryKeySelective(CommodityInfoImage record);

    int updateByPrimaryKey(CommodityInfoImage record);

    /**
     * 通过商品ID查询详情图（购买页下面的大图）
     * @param commodityId
     * @return
     */
    List<CommodityInfoImage> selectInfoImageListByCommodityId(Integer commodityId);
}