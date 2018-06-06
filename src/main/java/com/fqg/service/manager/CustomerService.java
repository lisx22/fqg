package com.fqg.service.manager;

import com.fqg.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {
    List<Customer> selectByPage(@Param("first")int first);
    int insert(Customer record);
}
