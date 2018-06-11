package com.fqg.entity;

import java.io.Serializable;
import java.util.List;

public class TypeOne implements Serializable {

    private Integer typeOneId;

    private String typeOneName;

    private List<TypeTwo> typeTwoList;

    private List<Brand> brandList;

    public List<TypeTwo> getTypeTwoList() {
        return typeTwoList;
    }

    public void setTypeTwoList(List<TypeTwo> typeTwoList) {
        this.typeTwoList = typeTwoList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

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