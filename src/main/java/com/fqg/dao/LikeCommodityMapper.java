package com.fqg.dao;

import com.fqg.entity.LikeCommodity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface LikeCommodityMapper {
    int deleteByPrimaryKey(Integer likeId);

    int insert(LikeCommodity record);

    int insertSelective(LikeCommodity record);

    LikeCommodity selectByPrimaryKey(Integer likeId);

    int updateByPrimaryKeySelective(LikeCommodity record);

    int updateByPrimaryKey(LikeCommodity record);

    List<LikeCommodity> selectByCustomer(Integer customerId);
}