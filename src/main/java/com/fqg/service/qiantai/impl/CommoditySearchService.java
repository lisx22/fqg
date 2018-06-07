package com.fqg.service.qiantai.impl;

import com.alibaba.fastjson.JSON;
import com.fqg.dao.CommoditySmallVOMapper;
import com.fqg.entity.CommoditySelect;
import com.fqg.entity.CommoditySmallVO;
import com.fqg.entity.PageInfo;
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
    private RedisUtil redisUtil;

    @Override
    public PageInfo<CommoditySmallVO> selectByCommoditySelect(CommoditySelect commoditySelect ,Integer pageNo) {
        Gson gson = new Gson();
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
        List<CommoditySmallVO> commoditySmallVOList = new ArrayList<>();
        List<Integer> commoditySmallVOIdList = commoditySmallVOMapper.selectByDynamicSQL(commoditySelect);
        for (Integer commodityId : commoditySmallVOIdList) {
            String key2 = "commoditySmallVO" + commodityId;
            CommoditySmallVO commoditySmallVO;
            try {
                commoditySmallVO = JSON.parseObject(redisUtil.get(key2).toString(), CommoditySmallVO.class);
                commoditySmallVOList.add(commoditySmallVO);
            } catch (NullPointerException e1) {
                synchronized (key2) {
                    try {
                        commoditySmallVO = JSON.parseObject(redisUtil.get(key2).toString(), CommoditySmallVO.class);
                        commoditySmallVOList.add(commoditySmallVO);
                    } catch (NullPointerException e2){
                        commoditySmallVO = commoditySmallVOMapper.selectByPrimaryKey(commodityId);
                        redisUtil.set(key2, gson.toJson(commoditySmallVO));
                        commoditySmallVOList.add(commoditySmallVO);
                    }
                }
            }
        }
        PageInfo<CommoditySmallVO> page=new PageInfo<>();
        page.setData(commoditySmallVOList);
        page.setPageCount(pageCount);
        page.setPageNo(pageNo);
        return page;
    }
}
