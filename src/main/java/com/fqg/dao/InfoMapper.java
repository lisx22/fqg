package com.fqg.dao;

import com.fqg.entity.Info;

import java.util.List;

public interface InfoMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer infoId);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

    /**
     * 通过商品ID查询此商品详情（32G）
     * @param commodityId
     * @return
     */
    List<Info> selectInfoListByCommodityId(Integer commodityId);
}