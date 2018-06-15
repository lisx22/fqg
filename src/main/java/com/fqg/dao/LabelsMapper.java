package com.fqg.dao;

import com.fqg.entity.Labels;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
@MapperScan
public interface LabelsMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(Labels record);

    int insertSelective(Labels record);

    Labels selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(Labels record);

    int updateByPrimaryKey(Labels record);

    /**
     * 通过商品ID查询标签集合（支持7天无理由退货）
     * @param commodityId
     * @return
     */
    List<Labels> selectLabelListByCommodityId(Integer commodityId);
}