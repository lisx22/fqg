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

    List<Commodity> selectByTypeOnePaging(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeTwoPaging(
            @Param("typeTwoId") Integer typeTwoId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeThreePaging(
            @Param("typeThreeId") Integer typeThreeId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeOneAndBrandPaging(
            @Param("typeOneId") Integer typeOneId,
            @Param("brandId") Integer brandId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeTwoAndBrandPaging(
            @Param("typeTwoId") Integer typeTwoId,
            @Param("brandId") Integer brandId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeThreeAndBrandPaging(
            @Param("typeThreeId") Integer typeThreeId,
            @Param("brandId") Integer brandId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeOneAndPriceRangePaging(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPrice") Integer startPrice,
            @Param("endPrice") Integer endPrice,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeOneOrderByPrice(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeOneOrderByPriceDesc(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeOneOrderBySellNum(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    List<Commodity> selectByTypeOneOrderBySellNumDesc(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );
}