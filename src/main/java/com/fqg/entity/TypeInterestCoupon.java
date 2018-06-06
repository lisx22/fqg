package com.fqg.entity;

import java.io.Serializable;

public class TypeInterestCoupon implements Serializable {
    private Integer couponId;

    private Integer nointerestContent;

    private Integer number;

    private Integer typeId;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getNointerestContent() {
        return nointerestContent;
    }

    public void setNointerestContent(Integer nointerestContent) {
        this.nointerestContent = nointerestContent;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}