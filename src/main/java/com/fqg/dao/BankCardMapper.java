package com.fqg.dao;

import com.fqg.entity.BankCard;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface BankCardMapper {
    int deleteByPrimaryKey(Integer bankCardId);

    int insert(BankCard record);

    int insertSelective(BankCard record);

    BankCard selectByPrimaryKey(Integer bankCardId);

    int updateByPrimaryKeySelective(BankCard record);

    int updateByPrimaryKey(BankCard record);
}