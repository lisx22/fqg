package com.fqg.service.qiantai.impl;

import com.fqg.dao.OrdersMapper;
import com.fqg.entity.Orders;
import com.fqg.service.qiantai.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 15:26
 */
@Service
public class OrderServiceQT implements IOrderService {

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public void completeOrder(Integer orderId) {
        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        orders.setOrderState(4);
        ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public Orders selectById(Integer orderId) {
        return ordersMapper.selectByPrimaryKey(orderId);
    }
}
