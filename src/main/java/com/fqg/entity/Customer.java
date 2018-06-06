package com.fqg.entity;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private Integer customerId;

    private String phoneNumber;

    private String username;

    private String loginPassword;

    private String payPassword;

    private String trueName;

    private String idNumber;
    //所有额度
    private Integer allQuota;
    //当前额度
    private Integer quota;

    private String  createTime;

    private String companyName;

    private String schoolName;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public Integer getAllQuota() {
        return allQuota;
    }

    public void setAllQuota(Integer allQuota) {
        this.allQuota = allQuota;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public String  getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String  createTime) {
        this.createTime = createTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }
	@Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", payPassword='" + payPassword + '\'' +
                ", trueName='" + trueName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", allQuota=" + allQuota +
                ", quota=" + quota +
                ", createTime=" + createTime +
                ", companyName='" + companyName + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}