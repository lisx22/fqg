package com.fqg.service.manager;

import com.fqg.entity.KillCommodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KillCommodityService {
    List<KillCommodity> selectByPage(@Param("first")int first);
    int insert(KillCommodity record);
    int updateByPrimaryKey(KillCommodity record);
    KillCommodity selectByPrimaryKey(Integer killCommodityId);
    int deleteByPrimaryKey(Integer killCommodityId);
    int selectCount();
}
