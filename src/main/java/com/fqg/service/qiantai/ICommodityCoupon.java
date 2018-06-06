package com.fqg.service.qiantai;

import com.fqg.entity.CommodityCoupon;
import org.springframework.stereotype.Service;

/**
 * 商品可领优惠券service接口
 * @author zhj
 * @time 2016/6/6
 */
@Service
public interface ICommodityCoupon {
    CommodityCoupon coupon(int typeId,int price);
}
