package com.fqg.service.qiantai;

import com.fqg.entity.Orders;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 15:25
 */
public interface IOrderService {
    void completeOrder(Integer orderId);

    Orders selectById(Integer orderId);
}
