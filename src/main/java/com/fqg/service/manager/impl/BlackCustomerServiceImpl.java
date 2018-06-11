package com.fqg.service.manager.impl;

import com.fqg.dao.BlackCustomerMapper;
import com.fqg.entity.BlackCustomer;
import com.fqg.service.manager.BlackCustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BlackCustomerServiceImpl implements BlackCustomerService{

    private static final int pageSize = 15;

    @Resource
    private BlackCustomerMapper blackCustomerDAO;

    public List<BlackCustomer> selectByPage(@Param("first")int first){
        int page = first*pageSize;
        return blackCustomerDAO.selectByPage(page, pageSize);
    }

    public int insert(BlackCustomer record){
        blackCustomerDAO.insert(record);
        return 0;
    }


    public BlackCustomer selectByPrimaryKey(Integer id){
        return blackCustomerDAO.selectByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(Integer id){
        blackCustomerDAO.deleteByPrimaryKey(id);
        return 0;
    }

    public int selectCount(){
        int count =  blackCustomerDAO.selectCount();
        int pageCount;
        if(count%pageSize==0){
            pageCount = count/pageSize;
        }else{
            pageCount= count/pageSize+1;
        }
        return pageCount;

    }

    public List<BlackCustomer> selectByID(String id){
         return blackCustomerDAO.selectByID(id);
    }
}
