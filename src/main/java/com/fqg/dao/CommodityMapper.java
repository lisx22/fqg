package com.fqg.dao;

import com.fqg.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper {

    int deleteByPrimaryKey(Integer commodityId);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer commodityId);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);

    Integer selectPriceById(Integer commodityId);

    List<Commodity> selectByTypeOnePaging(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );
}