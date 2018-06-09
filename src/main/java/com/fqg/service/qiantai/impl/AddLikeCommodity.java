package com.fqg.service.qiantai.impl;

import com.fqg.dao.CommoditySmallVOMapper;
import com.fqg.dao.LikeCommodityMapper;
import com.fqg.entity.Customer;
import com.fqg.entity.LikeCommodity;
import com.fqg.service.qiantai.IAddLikeCommodity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 加入收藏夹并返回收藏表中消息
 *@author zhj
 * @time 2018/6/9
 */
@Service
@Transactional
public class AddLikeCommodity implements IAddLikeCommodity{
    @Resource
    private LikeCommodityMapper likeCommodityMapper;
    @Resource
    private CommoditySmallVOMapper commoditySmallVOMapper;
    @Resource
    LikeCommodity likeCommodity;
    @Override
    public List<LikeCommodity> addLikeCommodity(Customer customer, int commodityId) {
        // 将商品纯入收藏列表
        likeCommodity.setCommodityId(commodityId);
        likeCommodity.setCustomerId(customer.getCustomerId());
        likeCommodityMapper.insert(likeCommodity);
        //查询该用户所有收藏商品
        List<LikeCommodity> likeCommodities = likeCommodityMapper.selectByCustomer(customer.getCustomerId());
        // 查询商品详情
        for (LikeCommodity commodity : likeCommodities) {
            commodity.setCommoditySmallVO(commoditySmallVOMapper.selectByPrimaryKey(commodity.getCommodityId()));
        }
        return likeCommodities;
    }
}
