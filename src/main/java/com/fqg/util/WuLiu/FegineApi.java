package com.fqg.util.WuLiu;
/**
全球快递物流查询
 商品购买地址： https://market.aliyun.com/products/56928004/cmapi023201.html
 String host = "http://wdexpress.market.alicloudapi.com"; //服务器
 String path = "/gxali"; //接口地址
 */


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class FegineApi {
    public static String getwuliu() {
        String host = "http://wdexpress.market.alicloudapi.com";
        String path = "/gxali";
        String method = "GET";
        String appcode = "aa953d17836242a5b9b0d74894e99ac8";  // !!! 替换这里填写你自己的AppCode 请在买家中心查看
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("n", "71345111818798");// !!! 请求参数
        querys.put("t", "HTKY");// !!! 请求参数
        String string = "";
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString()); //输出头部
            string = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }
}
