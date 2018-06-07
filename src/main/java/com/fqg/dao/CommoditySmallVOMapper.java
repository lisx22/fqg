package com.fqg.dao;

import com.fqg.entity.CommoditySelect;
import com.fqg.entity.CommoditySmallVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/7
 * @Time 11:14
 */
public interface CommoditySmallVOMapper {

    /*List<CommoditySmallVO> selectByTypeOnePaging(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    Integer countByTypeOne(Integer typeOneId);

    List<CommoditySmallVO> selectByTypeTwoPaging(
            @Param("typeTwoId") Integer typeTwoId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    Integer countByTypeTwo(Integer typeTwoId);

    List<CommoditySmallVO> selectByTypeThreePaging(
            @Param("typeThreeId") Integer typeThreeId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    Integer countByTypeThree(Integer typeThree);

    List<CommoditySmallVO> selectByTypeOneAndBrandPaging(
            @Param("typeOneId") Integer typeOneId,
            @Param("brandId") Integer brandId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    Integer countByTypeOneAndBrand(
            @Param("typeOneId") Integer typeOneId,
            @Param("brandId") Integer brandId
    );

    List<CommoditySmallVO> selectByTypeTwoAndBrandPaging(
            @Param("typeTwoId") Integer typeTwoId,
            @Param("brandId") Integer brandId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    Integer countByTypeTwoAndBrand(
            @Param("typeTwoId") Integer typeTwoId,
            @Param("brandId") Integer brandId
    );

    List<CommoditySmallVO> selectByTypeThreeAndBrandPaging(
            @Param("typeThreeId") Integer typeThreeId,
            @Param("brandId") Integer brandId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    Integer countByTypeThreeAndBrand(
            @Param("typeThreeId") Integer typeThreeId,
            @Param("brandId") Integer brandId
    );

    List<CommoditySmallVO> selectByTypeOneAndPriceRangePaging(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPrice") Integer startPrice,
            @Param("endPrice") Integer endPrice,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );

    Integer countByTypeOneAndPriceRange(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPrice") Integer startPrice,
            @Param("endPrice") Integer endPrice
    );

    List<CommoditySmallVO> selectByTypeOneOrderByPrice(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );


    List<CommoditySmallVO> selectByTypeOneOrderByPriceDesc(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );


    List<CommoditySmallVO> selectByTypeOneOrderBySellNum(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );


    List<CommoditySmallVO> selectByTypeOneOrderBySellNumDesc(
            @Param("typeOneId") Integer typeOneId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize
    );*/

    List<CommoditySmallVO> selectByDynamicSQL(CommoditySelect commoditySelect);

    Integer countByDynamicSQL(CommoditySelect commoditySelect);
}
