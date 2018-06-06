package com.fqg.service.qiantai.impl;

import com.fqg.entity.Orders;
import com.fqg.service.qiantai.IAddOrderService;
import org.springframework.stereotype.Service;

/**
 * 查询商品价格判断余额是否足够支付，加入订单列表
 * @author zhj
 * @time 20118/6/6
 */
@Service
public class AddOrderService implements IAddOrderService{

    @Override
    public Orders addToOrder(String buyInfo) {
        //将客户端传递过来的值拆分为数组
        char[] infos = buyInfo.toCharArray();
        //查询商品初始价格
        int price =
        return null;
    }
}
