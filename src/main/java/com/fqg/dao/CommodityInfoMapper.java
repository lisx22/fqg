package com.fqg.dao;

import com.fqg.entity.CommodityInfo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface CommodityInfoMapper {
    int deleteByPrimaryKey(Integer commodityInfoId);

    int insert(CommodityInfo record);

    int insertSelective(CommodityInfo record);

    CommodityInfo selectByPrimaryKey(Integer commodityInfoId);

    int updateByPrimaryKeySelective(CommodityInfo record);

    int updateByPrimaryKey(CommodityInfo record);

    List<CommodityInfo> selectCIListByCommodityId(Integer commodityId);

    Integer selectPriceByCommodityIdAndInfoId(
            @Param("commodityId") Integer commodityId,
            @Param("infoId") Integer infoId
    );
}