package com.fqg.util.weixinPay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 11:04
 */
@WebServlet("/payment/result")
public class ResuletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        try {
            weixin_notify(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        this.doGet(req, resp);
    }

    public void weixin_notify(HttpServletRequest request,HttpServletResponse
            response) throws Exception{
        String writeContent="??????";
        String path = request.getServletContext().getRealPath("file");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOutputStream = new
                FileOutputStream(path+"/result.txt", true);
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s ;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,
                "UTF-8"));
        while ((s = in.readLine()) != null){
            sb.append(s);
        }
        in.close();
        inputStream.close();
        Map<String, String> m = new HashMap<String, String>();
        m = XMLUtil.doXMLParse(sb.toString());
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = m.get(parameter);
            String v = "";
            if(null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }
        String key = PayConfigUtil.API_KEY;
        System.err.println(packageParams);
        String out_trade_no = (String)packageParams.get("out_trade_no");
        if(PayCommonUtil.isTenpaySign("UTF-8", packageParams,key)) {
            String resXml = "";
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
                String mch_id = (String)packageParams.get("mch_id");
                String openid = (String)packageParams.get("openid");
                String is_subscribe = (String)packageParams.get("is_subscribe");
                String total_fee = (String)packageParams.get("total_fee");
                System.err.println("mch_id:"+mch_id);
                System.err.println("openid:"+openid);
                System.err.println("is_subscribe:"+is_subscribe);
                System.err.println("out_trade_no:"+out_trade_no);
                System.err.println("total_fee:"+total_fee);
                System.err.println("????");
                writeContent = "??:" + out_trade_no + "????";
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]> </return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            } else {
                writeContent = "??"+out_trade_no+"????,?????" +
                        packageParams.get("err_code");
                System.err.println("??"+out_trade_no+"????,?????" +
                        packageParams.get("err_code"));
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[????]]></return_msg>" + "</xml>";
            }
            BufferedOutputStream out = new BufferedOutputStream(
                    response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } else{
            writeContent = "??"+out_trade_no+"????????,????";
            System.err.println("123123123");
        }
        fileOutputStream.write(writeContent.getBytes());
        fileOutputStream.close();
    }
}
