package com.fqg.dao;

import com.fqg.entity.CommodityExhibitionImage;

public interface CommodityExhibitionImageMapper {
    int deleteByPrimaryKey(Integer exhibitionImageId);

    int insert(CommodityExhibitionImage record);

    int insertSelective(CommodityExhibitionImage record);

    CommodityExhibitionImage selectByPrimaryKey(Integer exhibitionImageId);

    int updateByPrimaryKeySelective(CommodityExhibitionImage record);

    int updateByPrimaryKey(CommodityExhibitionImage record);
}