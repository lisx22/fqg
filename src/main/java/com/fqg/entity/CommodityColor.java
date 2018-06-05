package com.fqg.entity;

import java.io.Serializable;

public class CommodityColor implements Serializable {
    private Integer commodityColorId;

    private Integer commodityId;

    private Integer colorId;

    private String imagePath;

    private Integer price;

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getCommodityColorId() {
        return commodityColorId;
    }

    public void setCommodityColorId(Integer commodityColorId) {
        this.commodityColorId = commodityColorId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}