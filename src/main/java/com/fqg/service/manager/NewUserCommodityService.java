package com.fqg.service.manager;

import com.fqg.entity.KillCommodity;
import com.fqg.entity.NewUserCommodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewUserCommodityService {
    List<NewUserCommodity> selectByPage(@Param("first")int first);
    int insert(NewUserCommodity record);
    int updateByPrimaryKey(NewUserCommodity record);
    NewUserCommodity selectByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    int selectCount();
}
