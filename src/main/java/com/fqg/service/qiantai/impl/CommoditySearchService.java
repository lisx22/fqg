package com.fqg.service.qiantai.impl;

import com.fqg.dao.CommodityMapper;
import com.fqg.entity.Commodity;
import com.fqg.entity.PageInfo;
import com.fqg.service.qiantai.ICommoditySearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/6
 * @Time 16:53
 */
@Service
public class CommoditySearchService implements ICommoditySearchService {

    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public PageInfo<Commodity> selectByTypeOnePaging(Integer typeOneId, Integer pageNo) {
        int total=commodityMapper.countByTypeOne(typeOneId);
        int pageCount=total% PageInfo.PAGE_SIZE==0?
                total/PageInfo.PAGE_SIZE:total/PageInfo.PAGE_SIZE+1;
        List<Commodity> commodityList=commodityMapper.selectByTypeOnePaging((pageNo-1)*PageInfo.PAGE_SIZE,
                PageInfo.PAGE_SIZE,typeOneId);
        PageInfo<Commodity> page=new PageInfo<>();
        page.setData(commodityList);
        page.setPageCount(pageCount);
        page.setPageNo(pageNo);
        return page;
    }

    @Override
    public PageInfo<Commodity> selectByTypeTwoPaging(Integer typeTwoId, Integer pageNo) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeThreePaging(Integer typeThreeId, Integer pageNo) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeOneAndBrandPaging(Integer typeOneId, Integer brandId, Integer pageNo) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeTwoAndBrandPaging(Integer typeTwoId, Integer brandId, Integer pageNo) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeThreeAndBrandPaging(Integer typeThreeId, Integer brandId, Integer pageNo) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeOneAndPriceRangePaging(Integer typeOneId, Integer startPrice, Integer endPrice, Integer pageNo) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeOneOrderByPrice(Integer typeOneId, Integer pageNo) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeOneOrderByPriceDesc(Integer typeOneId, Integer startPage, Integer pageSize) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeOneOrderBySellNum(Integer typeOneId, Integer startPage, Integer pageSize) {
        return null;
    }

    @Override
    public PageInfo<Commodity> selectByTypeOneOrderBySellNumDesc(Integer typeOneId, Integer startPage, Integer pageSize) {
        return null;
    }
}
