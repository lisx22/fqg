package com.fqg.util.utilClasses;

import com.fqg.entity.AllInterestCoupon;
import com.fqg.entity.AllPriceCoupon;
import com.fqg.entity.TypeInterestCoupon;
import com.fqg.entity.TypePriceCoupon;



public class Coupon {
    private AllInterestCoupon allInterestCoupon;
    private AllPriceCoupon allPriceCoupon;
    private TypeInterestCoupon typeInterestCoupon;
    private TypePriceCoupon typePriceCoupon;

    public AllInterestCoupon getAllInterestCoupon() {
        return allInterestCoupon;
    }

    public void setAllInterestCoupon(AllInterestCoupon allInterestCoupon) {
        this.allInterestCoupon = allInterestCoupon;
    }

    public AllPriceCoupon getAllPriceCoupon() {
        return allPriceCoupon;
    }

    public void setAllPriceCoupon(AllPriceCoupon allPriceCoupon) {
        this.allPriceCoupon = allPriceCoupon;
    }

    public TypeInterestCoupon getTypeInterestCoupon() {
        return typeInterestCoupon;
    }

    public void setTypeInterestCoupon(TypeInterestCoupon typeInterestCoupon) {
        this.typeInterestCoupon = typeInterestCoupon;
    }

    public TypePriceCoupon getTypePriceCoupon() {
        return typePriceCoupon;
    }

    public void setTypePriceCoupon(TypePriceCoupon typePriceCoupon) {
        this.typePriceCoupon = typePriceCoupon;
    }
}
