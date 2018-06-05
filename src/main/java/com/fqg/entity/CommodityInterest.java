package com.fqg.entity;

import java.io.Serializable;

public class CommodityInterest implements Serializable {
    private Integer commodityInterestId;

    private Integer ciCommodityId;

    private Integer ciInterestId;

    public Integer getCommodityInterestId() {
        return commodityInterestId;
    }

    public void setCommodityInterestId(Integer commodityInterestId) {
        this.commodityInterestId = commodityInterestId;
    }

    public Integer getCiCommodityId() {
        return ciCommodityId;
    }

    public void setCiCommodityId(Integer ciCommodityId) {
        this.ciCommodityId = ciCommodityId;
    }

    public Integer getCiInterestId() {
        return ciInterestId;
    }

    public void setCiInterestId(Integer ciInterestId) {
        this.ciInterestId = ciInterestId;
    }
}