package com.fqg.service.manager.impl;


import com.fqg.dao.OrdersMapper;
import com.fqg.entity.Orders;
import com.fqg.service.manager.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    /**
     * 每页十五条记录
     */
    private static final int pageSize = 15;
    @Resource
    private OrdersMapper ordersDAO;

    public List<Orders> selectByPage(@Param("first")int first){
        int page = first*pageSize;
        return ordersDAO.selectByPage(page, pageSize);
    }
    public int insert(Orders record){
        ordersDAO.insert(record);
        return 0;
    }
    public int updateByPrimaryKey(Orders record){
        ordersDAO.updateByPrimaryKey(record);
        return 0;
    }
    public Orders selectByPrimaryKey(Integer ordersId){
        return ordersDAO.selectByPrimaryKey(ordersId);
    }

    public int deleteByPrimaryKey(Integer ordersId){
        ordersDAO.deleteByPrimaryKey(ordersId);
        return 0;
    }

    public int selectCount(){
        int count =  ordersDAO.selectCount();
        int pageCount;
        if(count%pageSize==0){
            pageCount = count/pageSize;
        }else{
            pageCount= count/pageSize+1;
        }
        return pageCount;

    }
}
