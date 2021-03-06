package com.fqg.entity;

import java.io.Serializable;

public class AllPriceCoupon implements Serializable {
    private Integer couponId;

    private Integer conditionAmount;

    private Integer reduceAmount;

    private Integer number;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getConditionAmount() {
        return conditionAmount;
    }

    public void setConditionAmount(Integer conditionAmount) {
        this.conditionAmount = conditionAmount;
    }

    public Integer getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(Integer reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}