package com.fqg.dao;

import com.fqg.entity.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderId);
    Integer selectByNum(Integer num);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}