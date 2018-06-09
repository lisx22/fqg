package com.fqg.entity;

import java.io.Serializable;

public class LikeCommodity implements Serializable {
    private Integer likeId;

    private Integer customerId;

    private Integer commodityId;

    private CommoditySmallVO commoditySmallVO;

    public CommoditySmallVO getCommoditySmallVO() {
        return commoditySmallVO;
    }

    public void setCommoditySmallVO(CommoditySmallVO commoditySmallVO) {
        this.commoditySmallVO = commoditySmallVO;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }
}