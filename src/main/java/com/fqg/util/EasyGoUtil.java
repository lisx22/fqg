package com.fqg.util;

import io.goeasy.GoEasy;

public class EasyGoUtil {
    public void easyGO(){

        GoEasy goEasy = new GoEasy("rest-hangzhou.goeasy.io","BC-55d4d6fb978c46468b41e34193467a75");

        goEasy.publish("my_channel","你有新的订单！");

    }

    public static void main(String[] args) {
        new EasyGoUtil().easyGO();
    }
}
