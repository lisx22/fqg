package com.fqg.dao;

import com.fqg.entity.CommodityExhibitionImage;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface CommodityExhibitionImageMapper {
    int deleteByPrimaryKey(Integer exhibitionImageId);

    int insert(CommodityExhibitionImage record);

    int insertSelective(CommodityExhibitionImage record);

    CommodityExhibitionImage selectByPrimaryKey(Integer exhibitionImageId);

    int updateByPrimaryKeySelective(CommodityExhibitionImage record);

    int updateByPrimaryKey(CommodityExhibitionImage record);

    /**
     * 通过商品ID查询此商品的展示图（商品购买页左侧小图）
     * @param commodityId
     * @return
     */
    List<CommodityExhibitionImage> selectExhibitionImageListByCommodityId(Integer commodityId);
}