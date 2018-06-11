package com.fqg.util.weixinPay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 10:00
 */
@Controller
@RequestMapping("/payment")
public class ImageServlet{
    @RequestMapping("/image")
    public void image(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedImage image = (BufferedImage)
                req.getSession().getAttribute("image");
        if (image != null) {
            ImageIO.write(image, "JPEG", resp.getOutputStream());
        }
    }
}
