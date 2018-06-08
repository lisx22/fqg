package com.fqg.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class TestHttpUtils {
    public static void main(String[] args) {
        String host = "https://feginesms.market.alicloudapi.com";
        String path = "/codeNotice";
        String method = "GET";
        String appcode = "4f196c6d8efa49f99437c1b3e4a2123d";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("param", "我爱你，老婆");
        querys.put("phone", "13667156261");
        querys.put("sign", "1");
        querys.put("skin", "1");
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse httpResponse = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());
            System.out.println(EntityUtils.toString(httpResponse.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
