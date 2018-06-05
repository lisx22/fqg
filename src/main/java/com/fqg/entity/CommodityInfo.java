package com.fqg.entity;

public class CommodityInfo {
    private Integer commodityInfoId;

    private Integer ciCommodityId;

    private Integer ciInfoId;

    private Integer price;

    public Integer getCommodityInfoId() {
        return commodityInfoId;
    }

    public void setCommodityInfoId(Integer commodityInfoId) {
        this.commodityInfoId = commodityInfoId;
    }

    public Integer getCiCommodityId() {
        return ciCommodityId;
    }

    public void setCiCommodityId(Integer ciCommodityId) {
        this.ciCommodityId = ciCommodityId;
    }

    public Integer getCiInfoId() {
        return ciInfoId;
    }

    public void setCiInfoId(Integer ciInfoId) {
        this.ciInfoId = ciInfoId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}