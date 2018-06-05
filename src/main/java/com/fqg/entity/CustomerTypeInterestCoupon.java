package com.fqg.entity;

import java.io.Serializable;

public class CustomerTypeInterestCoupon implements Serializable {
    private Integer customerCouponId;

    private Integer ccCouponId;

    private Integer ccCustomerId;

    public Integer getCustomerCouponId() {
        return customerCouponId;
    }

    public void setCustomerCouponId(Integer customerCouponId) {
        this.customerCouponId = customerCouponId;
    }

    public Integer getCcCouponId() {
        return ccCouponId;
    }

    public void setCcCouponId(Integer ccCouponId) {
        this.ccCouponId = ccCouponId;
    }

    public Integer getCcCustomerId() {
        return ccCustomerId;
    }

    public void setCcCustomerId(Integer ccCustomerId) {
        this.ccCustomerId = ccCustomerId;
    }
}