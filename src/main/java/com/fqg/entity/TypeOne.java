package com.fqg.entity;

public class TypeOne {
    private Integer typeOneId;

    private String typeOneName;

    public Integer getTypeOneId() {
        return typeOneId;
    }

    public void setTypeOneId(Integer typeOneId) {
        this.typeOneId = typeOneId;
    }

    public String getTypeOneName() {
        return typeOneName;
    }

    public void setTypeOneName(String typeOneName) {
        this.typeOneName = typeOneName == null ? null : typeOneName.trim();
    }
}