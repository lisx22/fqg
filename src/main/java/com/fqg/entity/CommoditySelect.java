package com.fqg.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/7
 * @Time 11:43
 */
public class CommoditySelect {

    private Integer typeOneId;

    private Integer typeTwoId;

    private Integer typeThreeId;

    private Integer brandId;

    private Integer startPrice;

    private Integer endPrice;

    private Integer startPage;

    private Integer pageSize;

    private Integer orderByPrice;

    private Integer orderBySellNum;

    public Integer getOrderByPrice() {
        return orderByPrice;
    }

    public void setOrderByPrice(Integer orderByPrice) {
        this.orderByPrice = orderByPrice;
    }

    public Integer getOrderBySellNum() {
        return orderBySellNum;
    }

    public void setOrderBySellNum(Integer orderBySellNum) {
        this.orderBySellNum = orderBySellNum;
    }

    public Integer getTypeOneId() {
        return typeOneId;
    }

    public void setTypeOneId(Integer typeOneId) {
        this.typeOneId = typeOneId;
    }

    public Integer getTypeTwoId() {
        return typeTwoId;
    }

    public void setTypeTwoId(Integer typeTwoId) {
        this.typeTwoId = typeTwoId;
    }

    public Integer getTypeThreeId() {
        return typeThreeId;
    }

    public void setTypeThreeId(Integer typeThreeId) {
        this.typeThreeId = typeThreeId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
