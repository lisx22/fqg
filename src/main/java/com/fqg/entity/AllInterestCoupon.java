package com.fqg.entity;

import java.io.Serializable;

public class AllInterestCoupon implements Serializable {
    private Integer couponId;

    private Integer nointerestContent;

    private Integer number;

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