package com.fqg.service.qiantai.impl;

import com.alibaba.fastjson.JSON;
import com.fqg.dao.CommoditySmallVOMapper;
import com.fqg.entity.CommoditySelect;
import com.fqg.entity.CommoditySmallVO;
import com.fqg.entity.PageInfo;
import com.fqg.entity.TypeOne;
import com.fqg.service.qiantai.ICommoditySearchService;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private CommoditySmallVOMapper commoditySmallVOMapper;

    @Resource
    private TypeOneService typeOneService;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public PageInfo<CommoditySmallVO> selectByCommoditySelect(CommoditySelect commoditySelect ,Integer pageNo) {
        commoditySelect.setStartPage((pageNo-1)*PageInfo.PAGE_SIZE);
        commoditySelect.setPageSize(PageInfo.PAGE_SIZE);
        Integer total;
        String key1 = String.valueOf(commoditySelect.hashCode());
        try{
            total = Integer.parseInt(redisUtil.get(key1).toString());
        } catch (NullPointerException e1) {
            synchronized (key1) {
                try {
                    total = Integer.parseInt(redisUtil.get(key1).toString());
                } catch (NullPointerException e2) {
                    total = commoditySmallVOMapper.countByDynamicSQL(commoditySelect);
                    redisUtil.set(key1,String.valueOf(total));
                }
            }
        }
        int pageCount=total% PageInfo.PAGE_SIZE == 0?
                total/PageInfo.PAGE_SIZE:total/PageInfo.PAGE_SIZE+1;
        List<Integer> commoditySmallVOIdList = commoditySmallVOMapper.selectByDynamicSQL(commoditySelect);
        List<CommoditySmallVO> commoditySmallVOList = selectCommoditySmallVOListById(commoditySmallVOIdList);
        PageInfo<CommoditySmallVO> page=new PageInfo<>();
        page.setData(commoditySmallVOList);
        page.setPageCount(pageCount);
        page.setPageNo(pageNo);
        return page;
    }

    @Override
    public List<CommoditySmallVO> selectOrderByCreateTime() {
        List<Integer> commoditySmallVOIdList = commoditySmallVOMapper.selectOrderByCreateTime();
        List<CommoditySmallVO> commoditySmallVOList = selectCommoditySmallVOListById(commoditySmallVOIdList);
        return commoditySmallVOList;
    }

    @Override
    public List<CommoditySmallVO> selectBrowseCommodityByCustomer(Integer customerId) {
        List<Integer> commoditySmallVOIdList = commoditySmallVOMapper.selectBrowseCommodityByCustomer(customerId);
        List<CommoditySmallVO> commoditySmallVOList = selectCommoditySmallVOListById(commoditySmallVOIdList);
        return commoditySmallVOList;
    }

    @Override
    public TypeOne selectById(Integer typeOneId) {
        return typeOneService.selectById(typeOneId);
    }

    @Override
    public CommoditySmallVO selectByCommodityId(Integer commodityId) {
        return commoditySmallVOMapper.selectByPrimaryKey(commodityId);
    }


    private List<CommoditySmallVO> selectCommoditySmallVOListById(List<Integer> commoditySmallVOIdList) {
        Gson gson = new Gson();
        List<CommoditySmallVO> commoditySmallVOList = new ArrayList<>();
        for (Integer commodityId : commoditySmallVOIdList) {
            String key = "commoditySmallVO" + commodityId;
            CommoditySmallVO commoditySmallVO;
            try {
                commoditySmallVO = JSON.parseObject(redisUtil.get(key).toString(), CommoditySmallVO.class);
                commoditySmallVOList.add(commoditySmallVO);
            } catch (NullPointerException e1) {
                synchronized (key) {
                    try {
                        commoditySmallVO = JSON.parseObject(redisUtil.get(key).toString(), CommoditySmallVO.class);
                        commoditySmallVOList.add(commoditySmallVO);
                    } catch (NullPointerException e2){
                        commoditySmallVO = commoditySmallVOMapper.selectByPrimaryKey(commodityId);
                        redisUtil.set(key, gson.toJson(commoditySmallVO));
                        commoditySmallVOList.add(commoditySmallVO);
                    }
                }
            }
        }
        return commoditySmallVOList;
    }

}
