package com.fqg.service.qiantai;

import com.fqg.entity.Customer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 16:16
 */
public interface ICustomerService {

    Customer selectById(Integer customerId);

    void update(Customer customer);
}
