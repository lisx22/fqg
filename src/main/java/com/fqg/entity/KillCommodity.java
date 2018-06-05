package com.fqg.entity;

import java.io.Serializable;
import java.util.Date;

public class KillCommodity implements Serializable {
    private Integer killCommodityId;

    private Integer commodityId;

    private Commodity commodity;

    private Integer price;

    private Integer number;

    private Date createTime;

    private Date updateTime;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getKillCommodityId() {
        return killCommodityId;
    }

    public void setKillCommodityId(Integer killCommodityId) {
        this.killCommodityId = killCommodityId;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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