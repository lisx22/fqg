package com.fqg.entity;

public class CustomerPriceCoupon {
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