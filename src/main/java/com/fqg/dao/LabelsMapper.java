package com.fqg.dao;

import com.fqg.entity.Labels;

public interface LabelsMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(Labels record);

    int insertSelective(Labels record);

    Labels selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(Labels record);

    int updateByPrimaryKey(Labels record);
}