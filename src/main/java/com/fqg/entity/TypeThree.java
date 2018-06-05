package com.fqg.entity;

public class TypeThree {
    private Integer typeThreeId;

    private Integer typeTwoId;

    private String typeThreeName;

    public Integer getTypeThreeId() {
        return typeThreeId;
    }

    public void setTypeThreeId(Integer typeThreeId) {
        this.typeThreeId = typeThreeId;
    }

    public Integer getTypeTwoId() {
        return typeTwoId;
    }

    public void setTypeTwoId(Integer typeTwoId) {
        this.typeTwoId = typeTwoId;
    }

    public String getTypeThreeName() {
        return typeThreeName;
    }

    public void setTypeThreeName(String typeThreeName) {
        this.typeThreeName = typeThreeName == null ? null : typeThreeName.trim();
    }
}