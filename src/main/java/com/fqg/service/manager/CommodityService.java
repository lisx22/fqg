package com.fqg.service.manager;

import com.fqg.entity.TypeOne;

import java.util.List;

public interface CommodityService {
    public List<Commodity> selectByPage(int typeOneId, int first);
    public int insert(Commodity commodity);
    public int updateByPrimaryKey(Commodity commodity);
    public Commodity selectByPrimaryKey(Integer commodityId);
    public int deleteByPrimaryKey(Integer commodityId);
    public int selectCount(int typeOneId);
    public List<TypeOne> selectTypeOne();
}
