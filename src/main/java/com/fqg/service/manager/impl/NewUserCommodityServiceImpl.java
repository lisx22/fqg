package com.fqg.service.manager.impl;

import com.fqg.dao.NewUserCommodityMapper;
import com.fqg.entity.NewUserCommodity;
import com.fqg.service.manager.NewUserCommodityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class NewUserCommodityServiceImpl implements NewUserCommodityService{
    private static final int pageSize = 15;

    @Resource
    private NewUserCommodityMapper newUserCommodityDAO;

    /**
     *
     * @param first 第几页？
     * @return 当前页数的用户集合
     */
    public List<NewUserCommodity> selectByPage(@Param("first")int first){
        int page = first*pageSize;
        return newUserCommodityDAO.selectByPage(page, pageSize);
    }
    public int insert(NewUserCommodity record){
        newUserCommodityDAO.insert(record);
        return 0;
    }
    public int updateByPrimaryKey(NewUserCommodity record){
        newUserCommodityDAO.updateByPrimaryKey(record);
        return 0;
    }
    public NewUserCommodity selectByPrimaryKey(Integer id){
        return newUserCommodityDAO.selectByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(Integer id){
        newUserCommodityDAO.deleteByPrimaryKey(id);
        return 0;
    }

    public int selectCount(){
        int count =  newUserCommodityDAO.selectCount();
        int pageCount;
        if(count%pageSize==0){
            pageCount = count/pageSize;
        }else{
            pageCount= count/pageSize+1;
        }
        return pageCount;

    }
}
