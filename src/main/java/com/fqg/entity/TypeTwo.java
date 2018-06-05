package com.fqg.entity;

public class TypeTwo {
    private Integer typeTwoId;

    private Integer typeOneId;

    private String typeTwoName;

    public Integer getTypeTwoId() {
        return typeTwoId;
    }

    public void setTypeTwoId(Integer typeTwoId) {
        this.typeTwoId = typeTwoId;
    }

    public Integer getTypeOneId() {
        return typeOneId;
    }

    public void setTypeOneId(Integer typeOneId) {
        this.typeOneId = typeOneId;
    }

    public String getTypeTwoName() {
        return typeTwoName;
    }

    public void setTypeTwoName(String typeTwoName) {
        this.typeTwoName = typeTwoName == null ? null : typeTwoName.trim();
    }
}