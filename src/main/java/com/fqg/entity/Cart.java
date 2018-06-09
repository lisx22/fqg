package com.fqg.entity;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable {
    private Integer cartId;

    private Integer customerId;

    private Integer commodityId;

    private String  commodityInfo;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String  getCommodityInfo() {
        return commodityInfo;
    }

    public void setCommodityInfo(String  commodityInfo) {
        this.commodityInfo = commodityInfo;
    }
}