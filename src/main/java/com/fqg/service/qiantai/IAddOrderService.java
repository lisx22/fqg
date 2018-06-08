package com.fqg.service.qiantai;

import com.fqg.entity.Orders;
import org.springframework.stereotype.Service;

/**
 * 将商品加入订单列表
 * @author zhj
 * @time 2018/6/7
 */
@Service
public interface IAddOrderService {
    boolean addToOrder(Orders orders);
}
