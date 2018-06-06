package com.fqg.dao;

import com.fqg.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    /**
     * 通过主键查询真实姓名
     * @param customerId
     * @return
     */
    String selectTrueNameById(Integer customerId);

    /**
     * 分页查询用户
     * @param first 页面数
     * @param pageSize 每页个数
     * @return
     */
    List<Customer> selectByPage(@Param("first")int first, @Param("pageSize")int pageSize);
}