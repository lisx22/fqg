package com.fqg.service.user;

import com.fqg.entity.Customer;
import org.apache.shiro.authc.AuthenticationException;

public interface UserService {
    void login(String username,String password) throws AuthenticationException;
    Customer save(Customer customer)throws Exception;
}
