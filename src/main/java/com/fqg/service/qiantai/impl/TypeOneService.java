package com.fqg.service.qiantai.impl;

import com.fqg.dao.TypeOneMapper;
import com.fqg.entity.TypeOne;
import com.fqg.service.qiantai.ITypeOneService;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 10:38
 */
public class TypeOneService implements ITypeOneService {

    @Resource
    private TypeOneMapper typeOneMapper;

    @Override
    public TypeOne selectById(Integer typeOneId) {
        return typeOneMapper.selectByPrimaryKey(typeOneId);
    }
}
