package com.fqg.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/8
 * @Time 15:28
 */
public class Browse {

    private Integer browseId;

    private Integer customerId;

    private Integer commodityId;

    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getBrowseId() {
        return browseId;
    }

    public void setBrowseId(Integer browseId) {
        this.browseId = browseId;
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

    @Override
    public String toString() {
        return "Browse{" +
                "browseId=" + browseId +
                ", customerId=" + customerId +
                ", commodityId=" + commodityId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
