package com.fqg.util;

public class JsonResult {
    /**
     * 状态码
     */
    private int code;
    /**
     * 具体信息
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
