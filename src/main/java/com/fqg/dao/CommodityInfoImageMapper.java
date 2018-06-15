package com.fqg.dao;

import com.fqg.entity.CommodityInfoImage;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface CommodityInfoImageMapper {
    int deleteByPrimaryKey(Integer infoImageId);

    int insert(CommodityInfoImage record);

    int insertSelective(CommodityInfoImage record);

    CommodityInfoImage selectByPrimaryKey(Integer infoImageId);

    int updateByPrimaryKeySelective(CommodityInfoImage record);

    int updateByPrimaryKey(CommodityInfoImage record);

    /**
     * 通过商品ID查询详情图路径（购买页下面的大图）
     * @param commodityId
     * @return
     */
    List<CommodityInfoImage> selectInfoImageListByCommodityId(Integer commodityId);

    /**
     * 通过商品ID查询第一张详情图路径
     * @param commodityId
     * @return
     */
    String selectFirstImageByCommodity(Integer commodityId);
}