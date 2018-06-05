package com.fqg.entity;

import java.io.Serializable;

public class CustomerPriceCoupon implements Serializable {
    private Integer customerCouponId;

    private Integer ccCustomerId;

    private Integer ccCouponId;

    public Integer getCustomerCouponId() {
        return customerCouponId;
    }

    public void setCustomerCouponId(Integer customerCouponId) {
        this.customerCouponId = customerCouponId;
    }

    public Integer getCcCustomerId() {
        return ccCustomerId;
    }

    public void setCcCustomerId(Integer ccCustomerId) {
        this.ccCustomerId = ccCustomerId;
    }

    public Integer getCcCouponId() {
        return ccCouponId;
    }

    public void setCcCouponId(Integer ccCouponId) {
        this.ccCouponId = ccCouponId;
    }
}