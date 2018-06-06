package com.fqg.service.qiantai;

import com.fqg.entity.Commodity;
import com.fqg.entity.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/6
 * @Time 16:53
 */
public interface ICommoditySearchService {

    PageInfo<Commodity> selectByTypeOnePaging(
            Integer typeOneId, Integer pageNo
    );

    PageInfo<Commodity> selectByTypeTwoPaging(
            Integer typeTwoId, Integer pageNo
    );

    PageInfo<Commodity> selectByTypeThreePaging(
            Integer typeThreeId, Integer pageNo
    );

    PageInfo<Commodity> selectByTypeOneAndBrandPaging(
            Integer typeOneId, Integer brandId, Integer pageNo
    );

    PageInfo<Commodity> selectByTypeTwoAndBrandPaging(
            Integer typeTwoId, Integer brandId, Integer pageNo
    );

    PageInfo<Commodity> selectByTypeThreeAndBrandPaging(
            Integer typeThreeId, Integer brandId, Integer pageNo
    );

    PageInfo<Commodity> selectByTypeOneAndPriceRangePaging(
            Integer typeOneId, Integer startPrice, Integer endPrice, Integer pageNo
    );

    PageInfo<Commodity> selectByTypeOneOrderByPrice(
            Integer typeOneId, Integer pageNo
    );

    PageInfo<Commodity> selectByTypeOneOrderByPriceDesc(
            Integer typeOneId, Integer startPage, Integer pageSize
    );

    PageInfo<Commodity> selectByTypeOneOrderBySellNum(
            Integer typeOneId, Integer startPage, Integer pageSize
    );

    PageInfo<Commodity> selectByTypeOneOrderBySellNumDesc(
            Integer typeOneId, Integer startPage, Integer pageSize
    );
}
