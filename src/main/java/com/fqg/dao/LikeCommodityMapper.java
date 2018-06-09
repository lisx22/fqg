package com.fqg.dao;

import com.fqg.entity.LikeCommodity;

import java.util.List;

public interface LikeCommodityMapper {
    int deleteByPrimaryKey(Integer likeId);

    int insert(LikeCommodity record);

    int insertSelective(LikeCommodity record);

    LikeCommodity selectByPrimaryKey(Integer likeId);

    int updateByPrimaryKeySelective(LikeCommodity record);

    int updateByPrimaryKey(LikeCommodity record);

    List<LikeCommodity> selectByCustomer(Integer customerId);
}