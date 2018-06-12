package com.fqg.service.user.impl;

import com.fqg.dao.CustomerMapper;
import com.fqg.entity.Customer;
import com.fqg.service.user.UserService;
import com.fqg.util.AESTest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Customer selectById(Integer id) throws Exception{
       Customer customer =  customerMapper.selectByPrimaryKey(id);
       return customer;
    }

    @Resource
    private CustomerMapper customerMapper;
    @Override
    public Customer save(Customer customer) throws Exception {
                 customer.setPhoneNumber(customer.getPhoneNumber());
                 customer.setLoginPassword(customer.getLoginPassword());
//                 AES加密
                 AESTest.encrypt(customer.getLoginPassword());
                 customer.setPayPassword(customer.getPayPassword());
        //                 AES加密
                 AESTest.encrypt(customer.getPayPassword());
                 customerMapper.insert(customer);
                 return customer;
    }

    @Override
    public Customer selectByPhoneNumber(String phoneNumber) {
        return customerMapper.selectByPhoneNumber(phoneNumber);
    }

    @Override
    public void login(String username, String password) throws AuthenticationException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        subject.login(usernamePasswordToken);
    }
}
