package com.fqg.service.manager;

import com.fqg.entity.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> selectByPage(int first);
    int insert(Orders record);
    int updateByPrimaryKey(Orders record);
    Orders selectByPrimaryKey(Integer ordersId);
    int deleteByPrimaryKey(Integer ordersId);
    int selectCount();
}
