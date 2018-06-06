package com.fqg.entity;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable {
    private Integer cartId;

    private Integer customerId;

    private Integer commodityId;

    private String  createTime;

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

    public String  getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String  createTime) {
        this.createTime = createTime;
    }
}