package com.fqg.util;

import io.goeasy.GoEasy;

public class EasyGoUtil {
    public void easyGO(){
        GoEasy goEasy = new GoEasy("http(s)://<rest-hangzhou.goeasy.io>","BC-55d4d6fb978c46468b41e34193467a75");

        goEasy.publish("your_channel","又有新的订单啦");

    }
}
