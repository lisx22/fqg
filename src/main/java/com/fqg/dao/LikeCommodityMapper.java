package com.fqg.dao;

import com.fqg.entity.LikeCommodity;

public interface LikeCommodityMapper {
    int deleteByPrimaryKey(Integer likeId);

    int insert(LikeCommodity record);

    int insertSelective(LikeCommodity record);

    LikeCommodity selectByPrimaryKey(Integer likeId);

    int updateByPrimaryKeySelective(LikeCommodity record);

    int updateByPrimaryKey(LikeCommodity record);
}