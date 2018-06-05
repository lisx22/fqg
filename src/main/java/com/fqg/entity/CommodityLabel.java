package com.fqg.entity;

import java.io.Serializable;

public class CommodityLabel implements Serializable {
    private Integer commodityLabelId;

    private Integer clCommodityId;

    private Integer clLabelId;

    public Integer getCommodityLabelId() {
        return commodityLabelId;
    }

    public void setCommodityLabelId(Integer commodityLabelId) {
        this.commodityLabelId = commodityLabelId;
    }

    public Integer getClCommodityId() {
        return clCommodityId;
    }

    public void setClCommodityId(Integer clCommodityId) {
        this.clCommodityId = clCommodityId;
    }

    public Integer getClLabelId() {
        return clLabelId;
    }

    public void setClLabelId(Integer clLabelId) {
        this.clLabelId = clLabelId;
    }
}