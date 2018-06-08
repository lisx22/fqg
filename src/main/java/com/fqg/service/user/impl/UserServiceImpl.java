package com.fqg.service.user.impl;

import com.fqg.dao.CustomerMapper;
import com.fqg.entity.Customer;
import com.fqg.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private CustomerMapper customerMapper;
    @Override
    public Customer save(Customer customer) throws Exception {
                 customer.setLoginPassword(customer.getPhoneNumber());
                 customer.setLoginPassword(customer.getLoginPassword());
                 customer.setPayPassword(customer.getPayPassword());
                 customerMapper.insert(customer);
                 return customer;
    }

    @Override
    public void login(String username, String password) throws AuthenticationException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        subject.login(usernamePasswordToken);
    }
}
