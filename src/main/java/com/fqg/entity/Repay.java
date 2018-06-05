package com.fqg.entity;

public class Repay {
    private Integer repayId;

    private Integer customerId;

    private Integer orderId;

    private Integer paidStage;

    private Integer unpadiStage;

    private Integer willPayAmount;

    public Integer getRepayId() {
        return repayId;
    }

    public void setRepayId(Integer repayId) {
        this.repayId = repayId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPaidStage() {
        return paidStage;
    }

    public void setPaidStage(Integer paidStage) {
        this.paidStage = paidStage;
    }

    public Integer getUnpadiStage() {
        return unpadiStage;
    }

    public void setUnpadiStage(Integer unpadiStage) {
        this.unpadiStage = unpadiStage;
    }

    public Integer getWillPayAmount() {
        return willPayAmount;
    }

    public void setWillPayAmount(Integer willPayAmount) {
        this.willPayAmount = willPayAmount;
    }
}