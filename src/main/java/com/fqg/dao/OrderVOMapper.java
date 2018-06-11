package com.fqg.dao;

import com.fqg.entity.OrderVO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderVOMapper {
    List<OrderVO> selectByCustomer(Integer customerId);
}