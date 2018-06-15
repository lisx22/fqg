package com.fqg.dao;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface OverTimeInterestMapper {
    Double selectOverTimeInterest();
}
