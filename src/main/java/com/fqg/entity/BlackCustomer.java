package com.fqg.entity;

import java.io.Serializable;
import java.util.Date;

public class BlackCustomer implements Serializable {
    private Integer blackCustomerId;

    private Integer idNumber;

    private String  createTime;

    public Integer getBlackCustomerId() {
        return blackCustomerId;
    }

    public void setBlackCustomerId(Integer blackCustomerId) {
        this.blackCustomerId = blackCustomerId;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String  getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String  createTime) {
        this.createTime = createTime;
    }
}