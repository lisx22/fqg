package com.fqg.service.manager.impl;

import com.fqg.dao.CustomerMapper;
import com.fqg.entity.Customer;
import com.fqg.service.manager.CustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    /**
     * 每页十五条记录
     */
    private static final int pageSize = 15;

    @Resource
    private CustomerMapper customerDAO;

    public List<Customer> selectByPage(@Param("first")int first){
       return customerDAO.selectByPage(first, pageSize);

    }
}
