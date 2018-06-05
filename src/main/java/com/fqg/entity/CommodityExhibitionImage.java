package com.fqg.entity;

import java.io.Serializable;

public class CommodityExhibitionImage implements Serializable {
    private Integer exhibitionImageId;

    private Integer commodityId;

    private String exhibitionImagePath;

    public Integer getExhibitionImageId() {
        return exhibitionImageId;
    }

    public void setExhibitionImageId(Integer exhibitionImageId) {
        this.exhibitionImageId = exhibitionImageId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getExhibitionImagePath() {
        return exhibitionImagePath;
    }

    public void setExhibitionImagePath(String exhibitionImagePath) {
        this.exhibitionImagePath = exhibitionImagePath == null ? null : exhibitionImagePath.trim();
    }
}