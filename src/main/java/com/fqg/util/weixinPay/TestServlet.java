package com.fqg.util.weixinPay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 9:57
 */
@WebServlet("/payment/test")
public class TestServlet extends HttpServlet {
    Random random = new Random();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String price = "1";
        String body = req.getParameter("body");
        if (req.getMethod().equalsIgnoreCase("get")) {
            body = new String(body.getBytes("ISO8859-1"), "UTF-8");
        }
        String orderId = random.nextInt(100000000) + "";
        try {
            String url = PayCommonUtil.weixin_pay(price, body, orderId);
            BufferedImage image = ZxingUtil.createImage(url, 186, 186);
            req.getSession().setAttribute("oid",orderId);
            req.getSession().setAttribute("image", image);
            resp.sendRedirect("payment.ftl");
        } catch (Exception e) {
            e.printStackTrace();}
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        this.doGet(req, resp);
    }
}
