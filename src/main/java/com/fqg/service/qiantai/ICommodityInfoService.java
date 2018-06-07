package com.fqg.service.qiantai;

import com.fqg.entity.Commodity;
import org.springframework.stereotype.Service;

/**
 * 商品详情接口
 * @author zhj
 * @time 2018.6.5
 */
@Service
public interface ICommodityInfoService {
    Commodity commodityInfo(int commodityId);
}
