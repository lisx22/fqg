package com.fqg.service.qiantai.impl;

import com.alibaba.fastjson.JSONObject;
import com.fqg.entity.KillCommodity;
import com.fqg.service.qiantai.IKillCommoditiesService;
import com.fqg.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KillCommodityServie implements IKillCommoditiesService{
    @Resource
    private RedisUtil redisUtil;
    @Override
    public List<KillCommodity> allKillCommodity() {
        String s = redisUtil.get("allkillCommodities").toString();
        List<KillCommodity> killCommodities = JSONObject.parseObject(s,List.class);
        return killCommodities;
    }

    @Override
    public KillCommodity killCommodity(String killid) {
        System.out.println();
        String str = redisUtil.get("killcommodity"+killid).toString();
        KillCommodity killCommodity = JSONObject.parseObject(str,KillCommodity.class);
        return killCommodity;
    }
}
