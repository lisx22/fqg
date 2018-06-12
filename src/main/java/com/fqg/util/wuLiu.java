package com.fqg.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 物流查询
 * @author zhj
 * @time 2018/6/12
 */
public class wuLiu {
    public String wuliu(String jianma,String danhao){
        String content = "";
        String src = "http://api.56jiekou.com/index.php/openapi-api.html?key=79bbff54223f7d94be0388e3c67c3412&exp="+jianma+"&num="+danhao+"&note=0&sort=desc";
        try
        {
            URL url= new URL(src);
            //请将XXXX替换成您在http://www.56jiekou.com/query.html申请到的KEY
            //请将YYYY替换成您要查单子的快递公司简码
            //请将ZZZZ替换成您要查的单号
            URLConnection con=url.openConnection();
            con.setAllowUserInteraction(false);
            InputStream urlStream = url.openStream();
            String type = con.guessContentTypeFromStream(urlStream);
            String charSet=null;
            if (type == null)
                type = con.getContentType();

            if (type == null || type.trim().length() == 0 || type.trim().indexOf("text/html") < 0)
                return "";

            if(type.indexOf("charset=") > 0)
                charSet = type.substring(type.indexOf("charset=") + 8);

            byte b[] = new byte[10000];
            int numRead = urlStream.read(b);
             content = new String(b, 0, numRead);
            while (numRead != -1) {
                numRead = urlStream.read(b);
                if (numRead != -1) {
                    String newContent = new String(b, 0, numRead);
                    //String newContent = new String(b, 0, numRead, charSet);
                    content += newContent;
                }
            }
            System.out.println("content:" + content);
            urlStream.close();
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }
}
