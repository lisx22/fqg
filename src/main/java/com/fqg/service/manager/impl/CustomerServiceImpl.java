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

    /**
     *
     * @param first 第几页？
     * @return 当前页数的用户集合
     */
    public List<Customer> selectByPage(@Param("first")int first){
        int page = first*pageSize;
       return customerDAO.selectByPage(page, pageSize);

    }

    public int insert(Customer record){
        customerDAO.insert(record);
        return 0;
    }
}
