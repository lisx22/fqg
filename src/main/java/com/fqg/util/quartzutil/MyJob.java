package com.fqg.util.quartzutil;

import com.fqg.dao.KillCommodityMapper;
import com.fqg.entity.KillCommodity;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务类，定时将商品加入缓存
 * @author zhj
 * @time 2018/6/11
 */
@Component
public class MyJob implements Job{
    @Resource
    private KillCommodityMapper killCommodityMapper;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException  {
        //查询所有秒杀商品
        List<KillCommodity> killCommodities = killCommodityMapper.selectAll();
        //加入缓存
        Gson gson = new Gson();
        String str = gson.toJson(killCommodities);
        System.out.println(str);
        redisUtil.set("allkillCommodities",str);
        System.out.println("hahahahahhaha");
        for (KillCommodity killCommodity : killCommodities) {
            redisUtil.set("killcommodity"+killCommodity.getKillCommodityId(), gson.toJson(killCommodity));
            redisUtil.set("kill"+killCommodity.getKillCommodityId(),killCommodity.getNumber().toString());

            System.out.println("ahahahah"+redisUtil.get("killcommodity"+killCommodity.getKillCommodityId()));
        }
    }
}

