package com.fqg.dao;

import com.fqg.entity.BuyInterest;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface BuyInterestMapper {
    int deleteByPrimaryKey(Integer interestId);

    int insert(BuyInterest record);

    int insertSelective(BuyInterest record);

    BuyInterest selectByPrimaryKey(Integer interestId);

    int updateByPrimaryKeySelective(BuyInterest record);

    int updateByPrimaryKey(BuyInterest record);

    /**
     * 通过商品ID查询此商品可选的分期数
     * @param commodityId
     * @return
     */
    List<Integer> selectBuyInterestListByCommodityId(Integer commodityId);

}