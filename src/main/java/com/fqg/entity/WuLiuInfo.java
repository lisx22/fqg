package com.fqg.entity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/18
 * @Time 15:26
 */
public class WuLiuInfo {
    private String LogisticCode;
    private String ShipperCode;
    private List<Traces> Traces;
    private String State;
    private String Success;

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public List<com.fqg.entity.Traces> getTraces() {
        return Traces;
    }

    public void setTraces(List<com.fqg.entity.Traces> traces) {
        Traces = traces;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    @Override
    public String toString() {
        return "WuLiuInfo{" +
                "LogisticCode='" + LogisticCode + '\'' +
                ", ShipperCode='" + ShipperCode + '\'' +
                ", Traces=" + Traces +
                ", State='" + State + '\'' +
                ", Success='" + Success + '\'' +
                '}';
    }
}
