package com.fqg.service.qiantai.impl;

import com.fqg.dao.CustomerMapper;
import com.fqg.entity.Customer;
import com.fqg.service.qiantai.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 16:17
 */
@Service
public class CustomerServiceQT implements ICustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer selectById(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
