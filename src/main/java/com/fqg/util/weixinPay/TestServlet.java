package com.fqg.util.weixinPay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/payment")
public class TestServlet extends HttpServlet {
    Random random = new Random();

    @RequestMapping("/test")
    public void test(HttpServletRequest req, HttpServletResponse resp,String body) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String price = "1";
        if (req.getMethod().equalsIgnoreCase("get")) {
            body = new String(body.getBytes("ISO8859-1"), "UTF-8");
        }
        String orderId = random.nextInt(100000000) + "";
        try {
            String url = PayCommonUtil.weixin_pay(price, body, orderId);
            BufferedImage image = ZxingUtil.createImage(url, 300, 300);
            req.getSession().setAttribute("oid",orderId);
            req.getSession().setAttribute("image", image);
            resp.sendRedirect("payment.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
