package com.fqg.dao;

import com.fqg.entity.Cart;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface CartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectByCustomerId(Integer customerId);
}