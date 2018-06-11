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

    private Integer repayId;

    private CommoditySmallVO commoditySmallVO;

    private Integer payMoney;

    private Integer totalStage;

    private Integer paidStage;

    private Integer unPaidStage;

    private Integer unPaidMoney;

    public Integer getRepayId() {
        return repayId;
    }

    public void setRepayId(Integer repayId) {
        this.repayId = repayId;
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

    public Integer getTotalStage() {
        return totalStage;
    }

    public void setTotalStage(Integer totalStage) {
        this.totalStage = totalStage;
    }

    public Integer getPaidStage() {
        return paidStage;
    }

    public void setPaidStage(Integer paidStage) {
        this.paidStage = paidStage;
    }

    public Integer getUnPaidStage() {
        return unPaidStage;
    }

    public void setUnPaidStage(Integer unPaidStage) {
        this.unPaidStage = unPaidStage;
    }

    public Integer getUnPaidMoney() {
        return unPaidMoney;
    }

    public void setUnPaidMoney(Integer unPaidMoney) {
        this.unPaidMoney = unPaidMoney;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "orderId=" + orderId +
                ", repayId=" + repayId +
                ", commoditySmallVO=" + commoditySmallVO +
                ", payMoney=" + payMoney +
                ", totalStage=" + totalStage +
                ", paidStage=" + paidStage +
                ", unPaidStage=" + unPaidStage +
                ", unPaidMoney=" + unPaidMoney +
                '}';
    }
}

