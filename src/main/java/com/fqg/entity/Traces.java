package com.fqg.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/18
 * @Time 15:47
 */
public class Traces {

    private String AcceptStation;

    private String AcceptTime;

    public String getAcceptStation() {
        return AcceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        AcceptStation = acceptStation;
    }

    public String getAcceptTime() {
        return AcceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        AcceptTime = acceptTime;
    }

    @Override
    public String toString() {
        return "Traces{" +
                "AcceptStation='" + AcceptStation + '\'' +
                ", AcceptTime='" + AcceptTime + '\'' +
                '}';
    }
}
