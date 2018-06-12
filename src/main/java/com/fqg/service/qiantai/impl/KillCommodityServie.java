package com.fqg.service.qiantai.impl;

import com.alibaba.fastjson.JSONObject;
import com.fqg.entity.KillCommodity;
import com.fqg.service.qiantai.IKillCommoditiesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KillCommodityServie implements IKillCommoditiesService{
    @Override
    public List<KillCommodity> allKillCommodity() {
        List<KillCommodity> killCommodities = JSONObject.parseObject("allkillCommodities",List.class);
        return killCommodities;
    }

    @Override
    public KillCommodity killCommodity(String killid) {
        KillCommodity killCommodity = JSONObject.parseObject("killcommodity"+killid,KillCommodity.class);
        return killCommodity;
    }
}
