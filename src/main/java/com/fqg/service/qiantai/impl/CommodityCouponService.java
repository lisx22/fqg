package com.fqg.service.qiantai.impl;

import com.alibaba.fastjson.JSON;
import com.fqg.dao.AllInterestCouponMapper;
import com.fqg.dao.AllPriceCouponMapper;
import com.fqg.dao.TypeInterestCouponMapper;
import com.fqg.dao.TypePriceCouponMapper;
import com.fqg.entity.*;
import com.fqg.service.qiantai.ICommodityCoupon;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品优惠券查询
 * @author zhj
 * @timr 2018/6/6
 */
@Service
public class CommodityCouponService implements ICommodityCoupon{
    @Resource
    private AllInterestCouponMapper allInterestCouponMapper;
    @Resource
    private AllPriceCouponMapper allPriceCouponMapper;
    @Resource
    private TypeInterestCouponMapper typeInterestCouponMapper;
    @Resource
    private TypePriceCouponMapper typePriceCouponMapper;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public CommodityCoupon coupon(int typeId, int price) {
        Gson gson = new Gson();
        CommodityCoupon commodityCoupon = new CommodityCoupon();
        String str = "";
        if (redisUtil.get("commoditycoupon"+typeId+price) == null){
            //查询4中类型的商品可用的优惠券并纯入商品优惠券对象中
            List<AllInterestCoupon> allInterestCoupons = allInterestCouponMapper.selectAll();
            List<TypeInterestCoupon> typeInterestCoupons = typeInterestCouponMapper.selectByTypeId(typeId);
            List<AllPriceCoupon> allPriceCoupons = allPriceCouponMapper.selectByPrice(price);
            List<TypePriceCoupon> typePriceCoupons = typePriceCouponMapper.selectByTypeId(typeId);
            commodityCoupon.setAllInterestCoupon(allInterestCoupons);
            commodityCoupon.setAllPriceCoupon(allPriceCoupons);
            commodityCoupon.setTypeInterestCoupon(typeInterestCoupons);
            commodityCoupon.setTypePriceCoupon(typePriceCoupons);
            str = gson.toJson(commodityCoupon);
            redisUtil.set("commoditycoupon"+typeId+price,str);
            System.out.println(str);
        }else {
            str = redisUtil.get("commoditycoupon"+typeId+price).toString();
        }
        commodityCoupon = JSON.parseObject(str,CommodityCoupon.class);
        return commodityCoupon;
    }
}
