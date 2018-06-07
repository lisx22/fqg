package com.fqg.dao;

import com.fqg.entity.Brand;
import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Integer brandId);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer brandId);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    /**
     * 通过大类型ID查询品牌集合
     * @param typeOneId
     * @return
     */
    List<Brand> selectBrandListByTypeOne(Integer typeOneId);

    List<Brand> selectAll();

}