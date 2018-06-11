package com.fqg.service.qiantai;

import com.fqg.entity.KillCommodity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 使用秒杀商品接口
 * @author zhj
 * @time 2018/6/11
 */
@Service
public interface IKillCommoditiesService {
    List<KillCommodity> allKillCommodity();
    KillCommodity killCommodity(String killid);
}
