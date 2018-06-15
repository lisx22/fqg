package com.fqg.dao;

import com.fqg.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;


@MapperScan
public interface AdminMapper {
    Admin login(@Param("adminName")String adminName, @Param("adminPassword")String adminPassword);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}