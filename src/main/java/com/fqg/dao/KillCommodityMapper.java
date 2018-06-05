package com.fqg.dao;

import com.fqg.entity.KillCommodity;

public interface KillCommodityMapper {
    int deleteByPrimaryKey(Integer killCommodityId);

    int insert(KillCommodity record);

    int insertSelective(KillCommodity record);

    KillCommodity selectByPrimaryKey(Integer killCommodityId);

    int updateByPrimaryKeySelective(KillCommodity record);

    int updateByPrimaryKey(KillCommodity record);
}