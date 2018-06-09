package com.fqg.dao;

import com.fqg.entity.Cart;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectByCustoerId(Integer customerId);
}