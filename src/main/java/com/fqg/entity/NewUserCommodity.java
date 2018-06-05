package com.fqg.entity;

import java.io.Serializable;
import java.util.Date;

public class NewUserCommodity implements Serializable {
    private Integer newUerCommodityId;

    private Integer commodityId;

    private Commodity commodity;

    private Integer price;

    private Date createTime;

    private Date updateTime;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getNewUerCommodityId() {
        return newUerCommodityId;
    }

    public void setNewUerCommodityId(Integer newUerCommodityId) {
        this.newUerCommodityId = newUerCommodityId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}