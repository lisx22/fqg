package com.fqg.entity;

import java.util.List;

public class CommodityCoupon {
    private List<AllInterestCoupon> allInterestCoupon;
    private List<AllPriceCoupon>  allPriceCoupon;
    private List<TypeInterestCoupon> typeInterestCoupon;
    private List<TypePriceCoupon> typePriceCoupon;

    public List<AllInterestCoupon> getAllInterestCoupon() {
        return allInterestCoupon;
    }

    public void setAllInterestCoupon(List<AllInterestCoupon> allInterestCoupon) {
        this.allInterestCoupon = allInterestCoupon;
    }

    public List<AllPriceCoupon> getAllPriceCoupon() {
        return allPriceCoupon;
    }

    public void setAllPriceCoupon(List<AllPriceCoupon> allPriceCoupon) {
        this.allPriceCoupon = allPriceCoupon;
    }

    public List<TypeInterestCoupon> getTypeInterestCoupon() {
        return typeInterestCoupon;
    }

    public void setTypeInterestCoupon(List<TypeInterestCoupon> typeInterestCoupon) {
        this.typeInterestCoupon = typeInterestCoupon;
    }

    public List<TypePriceCoupon> getTypePriceCoupon() {
        return typePriceCoupon;
    }

    public void setTypePriceCoupon(List<TypePriceCoupon> typePriceCoupon) {
        this.typePriceCoupon = typePriceCoupon;
    }
}
