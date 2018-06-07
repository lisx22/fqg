package com.fqg.service.qiantai.impl;

import com.fqg.dao.*;
import com.fqg.entity.Customer;
import com.fqg.entity.Orders;
import com.fqg.service.qiantai.IAddOrderService;
import com.fqg.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 查询商品价格判断余额是否足够支付，加入订单列表
 * @author zhj
 * @time 20118/6/6
 */
@Service
public class AddOrderService implements IAddOrderService{
    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private AllInterestCouponMapper allInterestCouponMapper;
    @Resource
    private AllPriceCouponMapper allPriceCouponMapper;
    @Resource
    private CommodityColorMapper commodityColorMapper;
    @Resource
    private CommodityInfoMapper commodityInfoMapper;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private CustomerMapper customerMapper;
    @Override
    public String addToOrder(String buyInfo) {
        //将客户端传递过来的值拆分为数组
        String[] infos = buyInfo.split("-");
        Customer customer = customerMapper.selectByPrimaryKey(Integer.parseInt(infos[5]));
        if(Integer.parseInt(infos[6]) < Integer.parseInt(customer.getQuota()))
        //查询商品初始价格
        int price = commodityMapper.selectPriceById(Integer.parseInt(infos[0]));
        int allInterestCoupon = allInterestCouponMapper.selectByPrimaryKey(Integer.parseInt(infos[1])).getNointerestContent();
        int allPriceCoupon = allPriceCouponMapper.selectByPrimaryKey(Integer.parseInt(infos[2])).getReduceAmount();
        int colorPrice = commodityColorMapper.selectPriceByCommodityIdAndColorId(Integer.parseInt(infos[0]),Integer.parseInt(infos[3]));
        int infoPrice = 0;
        for (int i = 7;i < infos.length;i++){
            infoPrice += commodityColorMapper.selectPriceByCommodityIdAndColorId(Integer.parseInt(infos[0]),Integer.parseInt(infos[i]));
        }
        int buyPrice = price + colorPrice + infoPrice -allPriceCoupon;
        return null;
    }
}
