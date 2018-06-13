package com.fqg.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/12
 * @Time 14:12
 */
public class OverRepay {

    private Integer overId;

    private Integer customerId;

    private Integer overDay;

    private Double overAmount;

    public Integer getOverId() {
        return overId;
    }

    public void setOverId(Integer overId) {
        this.overId = overId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getOverDay() {
        return overDay;
    }

    public void setOverDay(Integer overDay) {
        this.overDay = overDay;
    }

    public Double getOverAmount() {
        return overAmount;
    }

    public void setOverAmount(Double overAmount) {
        this.overAmount = overAmount;
    }
}
