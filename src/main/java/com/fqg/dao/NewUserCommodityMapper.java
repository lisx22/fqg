package com.fqg.dao;

import com.fqg.entity.KillCommodity;
import com.fqg.entity.NewUserCommodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewUserCommodityMapper {
    int deleteByPrimaryKey(Integer newUerCommodityId);

    int insert(NewUserCommodity record);

    int insertSelective(NewUserCommodity record);

    NewUserCommodity selectByPrimaryKey(Integer newUerCommodityId);

    int updateByPrimaryKeySelective(NewUserCommodity record);

    int updateByPrimaryKey(NewUserCommodity record);

    List<NewUserCommodity> selectByPage(@Param("first")int first, @Param("pageSize")int pageSize);

    int selectCount();
}