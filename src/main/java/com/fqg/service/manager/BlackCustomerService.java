package com.fqg.service.manager;

import com.fqg.entity.BlackCustomer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlackCustomerService {
    List<BlackCustomer> selectByPage(@Param("first")int first);
    int insert(BlackCustomer record);
    BlackCustomer selectByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    int selectCount();
    List<BlackCustomer> selectByID(String id);
}
