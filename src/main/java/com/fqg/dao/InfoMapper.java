package com.fqg.dao;

import com.fqg.entity.Info;
import org.mybatis.spring.annotation.MapperScan;
@MapperScan
public interface InfoMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer infoId);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);


}