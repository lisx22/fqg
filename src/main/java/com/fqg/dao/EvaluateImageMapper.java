package com.fqg.dao;

import com.fqg.entity.EvaluateImage;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface EvaluateImageMapper {
    int deleteByPrimaryKey(Integer evaluateImageId);

    int insert(EvaluateImage record);

    int insertSelective(EvaluateImage record);

    EvaluateImage selectByPrimaryKey(Integer evaluateImageId);

    int updateByPrimaryKeySelective(EvaluateImage record);

    int updateByPrimaryKey(EvaluateImage record);
}