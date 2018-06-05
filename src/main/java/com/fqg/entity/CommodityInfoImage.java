package com.fqg.entity;

public class CommodityInfoImage {
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