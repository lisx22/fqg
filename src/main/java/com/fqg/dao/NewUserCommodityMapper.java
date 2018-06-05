package com.fqg.dao;

import com.fqg.entity.NewUserCommodity;

public interface NewUserCommodityMapper {
    int deleteByPrimaryKey(Integer newUerCommodityId);

    int insert(NewUserCommodity record);

    int insertSelective(NewUserCommodity record);

    NewUserCommodity selectByPrimaryKey(Integer newUerCommodityId);

    int updateByPrimaryKeySelective(NewUserCommodity record);

    int updateByPrimaryKey(NewUserCommodity record);
}