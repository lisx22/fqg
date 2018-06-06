package com.fqg.service.qiantai;

import com.fqg.entity.Orders;
import org.springframework.stereotype.Service;

/**
 * 购买商品加入订单表接口
 * @author zhj
 * @time 2016/6/6
 */
@Service
public interface IAddOrderService {
    Orders addToOrder(String buyInfo);
}
