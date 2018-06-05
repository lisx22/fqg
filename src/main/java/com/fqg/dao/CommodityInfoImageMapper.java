package com.fqg.dao;

import com.fqg.entity.CommodityInfoImage;

public interface CommodityInfoImageMapper {
    int deleteByPrimaryKey(Integer infoImageId);

    int insert(CommodityInfoImage record);

    int insertSelective(CommodityInfoImage record);

    CommodityInfoImage selectByPrimaryKey(Integer infoImageId);

    int updateByPrimaryKeySelective(CommodityInfoImage record);

    int updateByPrimaryKey(CommodityInfoImage record);
}