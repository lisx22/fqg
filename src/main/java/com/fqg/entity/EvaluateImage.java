package com.fqg.entity;

public class EvaluateImage {
    private Integer evaluateImageId;

    private Integer evaluateId;

    private String evaluateImagePath;

    public Integer getEvaluateImageId() {
        return evaluateImageId;
    }

    public void setEvaluateImageId(Integer evaluateImageId) {
        this.evaluateImageId = evaluateImageId;
    }

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getEvaluateImagePath() {
        return evaluateImagePath;
    }

    public void setEvaluateImagePath(String evaluateImagePath) {
        this.evaluateImagePath = evaluateImagePath == null ? null : evaluateImagePath.trim();
    }
}