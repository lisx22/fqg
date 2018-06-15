package com.fqg.dao;

import com.fqg.entity.KillCommodity;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface KillCommodityMapper {
    int deleteByPrimaryKey(Integer killCommodityId);

    int insert(KillCommodity record);

    int insertSelective(KillCommodity record);

    KillCommodity selectByPrimaryKey(Integer killCommodityId);

    int updateByPrimaryKeySelective(KillCommodity record);

    int updateByPrimaryKey(KillCommodity record);

    List<KillCommodity> selectByPage(@Param("first")int first, @Param("pageSize")int pageSize);

    int selectCount();

    List<KillCommodity> selectAll();
}