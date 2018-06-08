package com.fqg.util.utilClasses;

import com.fqg.entity.AllInterestCoupon;
import com.fqg.entity.AllPriceCoupon;
import com.fqg.entity.TypeInterestCoupon;
import com.fqg.entity.TypePriceCoupon;

import java.util.List;

public class CouponList {
    private List<AllInterestCoupon> list1;
    private List<AllPriceCoupon> list2;
    private List<TypeInterestCoupon> list3;
    private List<TypePriceCoupon> list4;

    public List<AllInterestCoupon> getList1() {
        return list1;
    }

    public void setList1(List<AllInterestCoupon> list1) {
        this.list1 = list1;
    }

    public List<AllPriceCoupon> getList2() {
        return list2;
    }

    public void setList2(List<AllPriceCoupon> list2) {
        this.list2 = list2;
    }

    public List<TypeInterestCoupon> getList3() {
        return list3;
    }

    public void setList3(List<TypeInterestCoupon> list3) {
        this.list3 = list3;
    }

    public List<TypePriceCoupon> getList4() {
        return list4;
    }

    public void setList4(List<TypePriceCoupon> list4) {
        this.list4 = list4;
    }

    public CouponList() {
    }

    public CouponList(List<AllInterestCoupon> list1, List<AllPriceCoupon> list2, List<TypeInterestCoupon> list3, List<TypePriceCoupon> list4) {
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.list4 = list4;
    }
}
