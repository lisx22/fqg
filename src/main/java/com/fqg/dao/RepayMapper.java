package com.fqg.dao;

import com.fqg.entity.Repay;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface RepayMapper {
    int deleteByPrimaryKey(Integer repayId);

    int insert(Repay record);

    int insertSelective(Repay record);

    Repay selectByPrimaryKey(Integer repayId);

    int updateByPrimaryKeySelective(Repay record);

    int updateByPrimaryKey(Repay record);

    List<Integer> selectWillPayAmountByCustomer(Integer customerId);

    List<Repay> selectByCustomer(Integer customerId);

    List<Repay> selectAll();
}