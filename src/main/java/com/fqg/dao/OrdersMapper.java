package com.fqg.dao;

import com.fqg.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderId);
    Integer selectByNum(Integer num);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> selectByPage(@Param("first")int first, @Param("pageSize")int pageSize);

    int selectCount();
}