package com.fqg.dao;

import com.fqg.entity.Browse;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/8
 * @Time 15:30
 */
public interface BrowseMapper {

    int insert(Browse browse);

    int deleteByPrimaryKey(Integer browseId);

    List<Browse> selectByCustomer(Integer customerId);
}
