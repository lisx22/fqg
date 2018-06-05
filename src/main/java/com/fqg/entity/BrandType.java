package com.fqg.entity;

import java.io.Serializable;

public class BrandType implements Serializable {
    private Integer brandTypeId;

    private Integer btBrandId;

    private Integer btTypeId;

    public Integer getBrandTypeId() {
        return brandTypeId;
    }

    public void setBrandTypeId(Integer brandTypeId) {
        this.brandTypeId = brandTypeId;
    }

    public Integer getBtBrandId() {
        return btBrandId;
    }

    public void setBtBrandId(Integer btBrandId) {
        this.btBrandId = btBrandId;
    }

    public Integer getBtTypeId() {
        return btTypeId;
    }

    public void setBtTypeId(Integer btTypeId) {
        this.btTypeId = btTypeId;
    }
}