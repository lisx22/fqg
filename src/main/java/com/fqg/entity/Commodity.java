package com.fqg.entity;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class Commodity {
    private Integer commodityId;

    private String commodityName;

    private Integer commodityPrice;

    private String commodityDescription;

    private Integer number;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private Integer commodityStatus;

    private Integer threeTypeId;

    private Integer twoTypeId;

    private Integer oneTypeId;

    private Integer noInterest;

    private List<CommodityColor> colors;

    private List<CommodityInfo> commodityInfos;

    private List<CommodityInfoImage> commodityInfoImages;

    private List<CommodityLabel>  commodityLabels;

    private List<CommodityExhibitionImage> commodityExhibitionImages;

    public List<CommodityColor> getColors() {
        return colors;
    }

    public void setColors(List<CommodityColor> colors) {
        this.colors = colors;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public Integer getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Integer commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityDescription() {
        return commodityDescription;
    }

    public void setCommodityDescription(String commodityDescription) {
        this.commodityDescription = commodityDescription == null ? null : commodityDescription.trim();
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

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(Integer commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public Integer getThreeTypeId() {
        return threeTypeId;
    }

    public void setThreeTypeId(Integer threeTypeId) {
        this.threeTypeId = threeTypeId;
    }

    public Integer getTwoTypeId() {
        return twoTypeId;
    }

    public void setTwoTypeId(Integer twoTypeId) {
        this.twoTypeId = twoTypeId;
    }

    public Integer getOneTypeId() {
        return oneTypeId;
    }

    public void setOneTypeId(Integer oneTypeId) {
        this.oneTypeId = oneTypeId;
    }
}