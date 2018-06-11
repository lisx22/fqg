package com.fqg.service.qiantai;

import com.fqg.entity.Customer;
import com.fqg.entity.Orders;
import org.springframework.stereotype.Service;

/**
 * 购买商品加入订单表之前的各种判断接口
 * @author zhj
 * @time 2016/6/6
 */
@Service
public interface IBeforeAddOrderService {
    String addToOrder(Customer customer,String buyInfo);
}
