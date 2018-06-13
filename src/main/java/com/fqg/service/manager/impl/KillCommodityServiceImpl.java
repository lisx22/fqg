package com.fqg.service.manager.impl;

import com.fqg.dao.KillCommodityMapper;
import com.fqg.entity.KillCommodity;
import com.fqg.service.manager.KillCommodityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class KillCommodityServiceImpl implements KillCommodityService{
    private static final int pageSize = 15;


    @Resource
    private KillCommodityMapper killCommodityDAO;

    /**
     *
     * @param first 第几页？
     * @return 当前页数的用户集合
     */
    public List<KillCommodity> selectByPage(@Param("first")int first){
        int page = first*pageSize;
        return killCommodityDAO.selectByPage(page, pageSize);
    }
    public int insert(KillCommodity record){
        killCommodityDAO.insert(record);
        return 0;
    }
    public int updateByPrimaryKey(KillCommodity record){
        killCommodityDAO.updateByPrimaryKey(record);
        return 0;
    }
    public KillCommodity selectByPrimaryKey(Integer killCommodityId){
        return killCommodityDAO.selectByPrimaryKey(killCommodityId);
    }

    public int deleteByPrimaryKey(Integer customerId){
        killCommodityDAO.deleteByPrimaryKey(customerId);
        return 0;
    }

    public int selectCount(){
        int count =  killCommodityDAO.selectCount();
        int pageCount;
        if(count%pageSize==0){
            pageCount = count/pageSize;
        }else{
            pageCount= count/pageSize+1;
        }
        return pageCount;

    }

}
