package com.fqg.service.manager;

import com.fqg.util.utilClasses.Coupon;
import com.fqg.util.utilClasses.CouponList;

public interface CouponService {
    CouponList selectByPage();
    void insert(Coupon coupon);
    void deleteById(int couponId,int typeId);
}
