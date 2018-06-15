package com.fqg.dao;

import com.fqg.entity.OrderVO;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan
public interface OrderVOMapper {
    List<OrderVO> selectByCustomer(Integer customerId);
}