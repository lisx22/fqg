package com.fqg.controller.payment;

import com.fqg.entity.Customer;
import com.fqg.service.qiantai.IRepayService;
import com.fqg.util.weixinPay.PayCommonUtil;
import com.fqg.util.weixinPay.PayConfigUtil;
import com.fqg.util.weixinPay.XMLUtil;
import com.fqg.util.weixinPay.ZxingUtil;
import org.jdom.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/15
 * @Time 17:33
 */
@Controller
@RequestMapping("/payment")
public class Payment {

    @Resource
    private IRepayService repayService;

    @RequestMapping("/test")
    public void test(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Random random = new Random();
        Integer integerOrderId = 10000000 + random.nextInt(89999999);
        String orderId = integerOrderId.toString();
        Customer customer =(Customer) req.getSession().getAttribute("customer");
        Integer customerId = customer.getCustomerId();
        String out_trade_no = orderId + customerId;
        req.setCharacterEncoding("UTF-8");
        String price = "1";
        String body = req.getParameter("body");
        if (req.getMethod().equalsIgnoreCase("get")) {
            body = new String(body.getBytes("ISO8859-1"), "UTF-8");
        }
        try {
            String url = PayCommonUtil.weixin_pay(price, body, out_trade_no);
            BufferedImage image = ZxingUtil.createImage(url, 186, 186);
            req.getSession().setAttribute("oid",orderId);
            req.getSession().setAttribute("image", image);
            resp.sendRedirect("payment.ftl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/test2")
    public void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Random random = new Random();
        Integer integerOrderId = 10000000 + random.nextInt(89999999);
        String orderId = integerOrderId.toString();
        Customer customer =(Customer) req.getSession().getAttribute("customer");
        Integer customerId = customer.getCustomerId();
        String out_trade_no = orderId + customerId;
        req.setCharacterEncoding("UTF-8");
        String price = "1";
        String body = req.getParameter("body");
        if (req.getMethod().equalsIgnoreCase("get")) {
            body = new String(body.getBytes("ISO8859-1"), "UTF-8");
        }
        try {
            String url = PayCommonUtil.weixin_pay2(price, body, out_trade_no);
            BufferedImage image = ZxingUtil.createImage(url, 186, 186);
            req.getSession().setAttribute("oid",orderId);
            req.getSession().setAttribute("image", image);
            resp.sendRedirect("payment.ftl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/image")
    public void image(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        BufferedImage image = (BufferedImage)
                req.getSession().getAttribute("image");
        if (image != null) {
            ImageIO.write(image, "JPEG", resp.getOutputStream());
        }
    }

    @RequestMapping("/result")
    public void result(HttpServletRequest req, HttpServletResponse resp) throws IOException, JDOMException {
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = req.getInputStream();
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
        System.out.println(packageParams);
        String out_trade_no = (String)packageParams.get("out_trade_no");
        String customerId = out_trade_no.substring(8);
        if(PayCommonUtil.isTenpaySign("UTF-8", packageParams,key)) {
            System.out.println("isTenpaySign");
            String resXml = "";
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
                System.out.println("success");
                repayService.doOverRepay(Integer.parseInt(customerId));
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]> </return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            } else {
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[????]]></return_msg>" + "</xml>";
            }
            BufferedOutputStream out = new BufferedOutputStream(
                    resp.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } else{
            System.err.println("123123123");
        }
    }

    @RequestMapping("/result2")
    public void result2(HttpServletRequest req, HttpServletResponse resp) throws IOException, JDOMException {
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = req.getInputStream();
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
        System.out.println(packageParams);
        String out_trade_no = (String)packageParams.get("out_trade_no");
        String customerId = out_trade_no.substring(8);
        if(PayCommonUtil.isTenpaySign("UTF-8", packageParams,key)) {
            System.out.println("isTenpaySign");
            String resXml = "";
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
                System.out.println("success");
                repayService.doThisMonthRepay(Integer.parseInt(customerId));
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]> </return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            } else {
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[????]]></return_msg>" + "</xml>";
            }
            BufferedOutputStream out = new BufferedOutputStream(
                    resp.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } else{
            System.err.println("123123123");
        }
    }
}
