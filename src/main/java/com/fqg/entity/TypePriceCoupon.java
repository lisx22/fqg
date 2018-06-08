package com.fqg.entity;

import java.io.Serializable;

public class TypePriceCoupon implements Serializable {
    private Integer couponId;

    private Integer conditionAmount;

    private Integer reduceAmount;

    private Integer typeId;

    private Integer number;

    private TypeOne typeOne;

    public TypeOne getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(TypeOne typeOne) {
        this.typeOne = typeOne;
    }

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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}