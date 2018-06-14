package com.fqg.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/9
 * @Time 14:40
 */
public class OrderVO {

    private Integer orderId;

    private String createTime;

    private String orderNum;

    private CommoditySmallVO commoditySmallVO;

    private Integer payMoney;

    private Integer amount;

    private Integer stage;

    private Integer state;

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public CommoditySmallVO getCommoditySmallVO() {
        return commoditySmallVO;
    }

    public void setCommoditySmallVO(CommoditySmallVO commoditySmallVO) {
        this.commoditySmallVO = commoditySmallVO;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

