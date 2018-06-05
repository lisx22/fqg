package com.fqg.entity;

import java.io.Serializable;

public class CommodityInfoImage implements Serializable {
    private Integer infoImageId;

    private Integer commodityId;

    private String infoImagePath;

    public Integer getInfoImageId() {
        return infoImageId;
    }

    public void setInfoImageId(Integer infoImageId) {
        this.infoImageId = infoImageId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getInfoImagePath() {
        return infoImagePath;
    }

    public void setInfoImagePath(String infoImagePath) {
        this.infoImagePath = infoImagePath == null ? null : infoImagePath.trim();
    }
}