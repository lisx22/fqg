package com.fqg.dao;

import com.fqg.entity.Color;
import org.mybatis.spring.annotation.MapperScan;
@MapperScan
public interface ColorMapper {
    int deleteByPrimaryKey(Integer colorId);

    int insert(Color record);

    int insertSelective(Color record);

    Color selectByPrimaryKey(Integer colorId);

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);


}