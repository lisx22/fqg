package com.fqg.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Commodity implements Serializable {

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

    private Integer noInterestStage;

    private TypeOne typeOne;

    private TypeTwo typeTwo;

    private TypeThree typeThree;

    private List<CommodityColor> ccList;

    private List<CommodityInfo> ciList;

    private List<CommodityInfoImage> commodityInfoImages;

    private List<Labels> labelsList;

    private List<CommodityExhibitionImage> commodityExhibitionImages;

    private List<Evaluate> evaluateList;

    public List<Evaluate> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<Evaluate> evaluateList) {
        this.evaluateList = evaluateList;
    }

    private List<BuyInterest> buyInterestList;

    private List<Property> properties;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<BuyInterest> getBuyInterestList() {
        return buyInterestList;
    }

    public void setBuyInterestList(List<BuyInterest> buyInterestList) {
        this.buyInterestList = buyInterestList;
    }



    public List<Labels> getLabelsList() {
        return labelsList;
    }

    public void setLabelsList(List<Labels> labelsList) {
        this.labelsList = labelsList;
    }

    public List<CommodityColor> getCcList() {
        return ccList;
    }

    public void setCcList(List<CommodityColor> ccList) {
        this.ccList = ccList;
    }

    public List<CommodityInfo> getCiList() {
        return ciList;
    }

    public void setCiList(List<CommodityInfo> ciList) {
        this.ciList = ciList;
    }

    public List<CommodityInfoImage> getCommodityInfoImages() {
        return commodityInfoImages;
    }

    public void setCommodityInfoImages(List<CommodityInfoImage> commodityInfoImages) {
        this.commodityInfoImages = commodityInfoImages;
    }

    public List<CommodityExhibitionImage> getCommodityExhibitionImages() {
        return commodityExhibitionImages;
    }

    public void setCommodityExhibitionImages(List<CommodityExhibitionImage> commodityExhibitionImages) {
        this.commodityExhibitionImages = commodityExhibitionImages;
    }

    public Integer getNoInterestStage() {
        return noInterestStage;
    }

    public void setNoInterestStage(Integer noInterestStage) {
        this.noInterestStage = noInterestStage;
    }

    public TypeOne getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(TypeOne typeOne) {
        this.typeOne = typeOne;
    }

    public TypeTwo getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(TypeTwo typeTwo) {
        this.typeTwo = typeTwo;
    }

    public TypeThree getTypeThree() {
        return typeThree;
    }

    public void setTypeThree(TypeThree typeThree) {
        this.typeThree = typeThree;
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