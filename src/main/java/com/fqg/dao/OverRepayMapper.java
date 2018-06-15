package com.fqg.dao;

import com.fqg.entity.OverRepay;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/12
 * @Time 14:20
 */
@MapperScan
public interface OverRepayMapper {

    List<OverRepay> selectAll();

    OverRepay selectByCustomer(Integer customerId);

    Integer deleteByCustomer(Integer customerId);

    Integer updateByPrimaryKeySelective(OverRepay overRepay);

    List<Integer> selectCustomerId();

    Integer insertSelective(OverRepay overRepay);
}
