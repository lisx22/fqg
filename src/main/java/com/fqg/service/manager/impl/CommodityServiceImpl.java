package com.fqg.service.manager.impl;

import com.fqg.dao.*;
import com.fqg.entity.Brand;
import com.fqg.entity.Commodity;
import com.fqg.entity.TypeOne;
import com.fqg.service.manager.CommodityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService{
    /**
     * 每页十五条记录
     */
    private static final int pageSize = 15;

    @Resource
    private CommodityMapper commodityDAO;

    @Resource
    private TypeOneMapper typeOneDAO;
    @Resource
    private TypeTwoMapper typeTwoDAO;
    @Resource
    private TypeThreeMapper typeThreeDAO;
    @Resource
    private BrandMapper brandDAO;

    /**
     * 按类型一分页查询
     * @param typeOneId 类型一的ID
     * @param first 页数
     * @return
     */
    public List<Commodity> selectByPage(int typeOneId,int first){
        int page = first*pageSize;
        return commodityDAO.selectByTypeOneOrderBySellNum(typeOneId,page,pageSize);
    }

    /**
     * 新增一个商品
     * @param commodity 商品对象
     * @return
     */
    public int insert(Commodity commodity){
        commodityDAO.insert(commodity);
        return 0;
    }

    /**
     * 修改商品属性
     * @param commodity 商品对象
     * @return
     */
    public int updateByPrimaryKey(Commodity commodity){
        commodityDAO.updateByPrimaryKey(commodity);
        return 0;
    }

    /**
     * 按主键查询商品
     * @param commodityId 商品主键
     * @return
     */
    public Commodity selectByPrimaryKey(Integer commodityId){
        return commodityDAO.selectByPrimaryKey(commodityId);
    }

    /**
     * 商品 按主键删除
     * @param commodityId 商品主键
     * @return
     */

    public int deleteByPrimaryKey(Integer commodityId){
        commodityDAO.deleteByPrimaryKey(commodityId);
        return 0;
    }

    /**
     * 按类型一分页查询的页面总数
     * @param typeOneId 类型一
     * @return 页面总数
     */
    public int selectCount(int typeOneId){
        int count = commodityDAO.countByTypeOne(typeOneId);
        int pageCount;
        if(count%pageSize==0){
            pageCount = count/pageSize;
        }else{
            pageCount= count/pageSize+1;
        }
        return pageCount;
    }

    /**
     * 查询所有typeOne
     * @return
     */
    public List<TypeOne> selectTypeOne(){
        return typeOneDAO.selectAll();
    }
    /**
     * 查询所有typeTwo
     * @return
     */
    public List<TypeOne> selectTypeTwo(){
        return typeTwoDAO.selectAll();
    }
    /**
     * 查询所有typeThree
     * @return
     */
    public List<Brand> selectBrand(){
        return brandDAO.selectAll();
    }

    /**
     * 查询所有typeThree
     * @return
     */
    public List<TypeOne> selectTypeThree(){
        return typeThreeDAO.selectAll();
    }

    /**
     * 按类型id查询类型一
     * @param id
     * @return
     */
    public TypeOne selectTypeName (int id){
        return typeOneDAO.selectByPrimaryKey(id);
    }


}
