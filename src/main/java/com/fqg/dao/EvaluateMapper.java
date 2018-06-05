package com.fqg.dao;

import com.fqg.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer evaluateId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer evaluateId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    /**
     * 通过商品ID查询此商品的所有评价
     * @param commodityId
     * @return
     */
    List<Evaluate> selectByCommodityIdPaging(
            @Param("commodityId") Integer commodityId,
            @Param("startPage") Integer startPage,
            @Param("pageSize") Integer pageSize);
}