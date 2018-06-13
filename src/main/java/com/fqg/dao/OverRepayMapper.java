package com.fqg.dao;

import com.fqg.entity.OverRepay;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/12
 * @Time 14:20
 */
public interface OverRepayMapper {
    OverRepay selectByCustomer(Integer customerId);
}
