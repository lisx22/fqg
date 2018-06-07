package com.fqg.service.qiantai.impl;

import com.alibaba.fastjson.JSON;
import com.fqg.dao.PropertyMapper;
import com.fqg.entity.*;
import com.fqg.service.qiantai.ICommodityInfoService;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *查询商品详情
 * @author 赵浩杰
 * @time 2018.6.5
 */
@Service
public class CommodityInfoService implements ICommodityInfoService {
    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private PropertyMapper propertyMapper;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public Commodity commodityInfo(int commodityId) {
        Gson gson = new Gson();
        //查询该商品数据
        Commodity commodity = new Commodity();
        String str = "";
        //先在redis中查询，若有值，返回，若无，在数据库中查询
        if(redisUtil.get("commodity"+commodityId) == null) {
            commodity = commodityMapper.selectByPrimaryKey(commodityId);
            //创建set集合用来装商品详情对应的属性id，和属性名
            List<Property> property = new ArrayList<>();
            Set<Integer> propertyId = new HashSet<>();
            //过滤重复的id；减轻压力
            for (CommodityInfo commodityInfo : commodity.getCiList()) {
                propertyId.add(commodityInfo.getInfo().getPropertyId());
            }
            //根据id查询该商品属性数据
            for (int i : propertyId) {
                property.add(propertyMapper.selectByPrimaryKey(i));
            }
            //将属性列表存储到商品对象中
            commodity.setProperties(property);
            //根据商品的免息期数来将对应的利息设为0
            for (BuyInterest interest : commodity.getBuyInterestList()) {
                if (interest.getStage() <= commodity.getNoInterestStage()) {
                    interest.setPercent(0.0);
                }
            }
            str = gson.toJson(commodity);
            //将查询出来的数据存入缓存
            redisUtil.set("commodity" + commodityId,str);
        }else {
            str = redisUtil.get("commodity"+commodityId).toString();
        }
        commodity = JSON.parseObject(str,Commodity.class);
        System.out.println(commodity.getCreateTime());
        return commodity;
    }
}
