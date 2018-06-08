package com.fqg.controller.user;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */
@WebServlet("/vcode.do")
public class VCodeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7094244787531735800L;
	private static final String CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int WIDTH = 80;
	private static final int HEIGHT =40;
	private static final Color[]COLOR = {Color.BLUE,Color.RED,Color.GREEN,Color.PINK,Color.YELLOW,Color.CYAN,Color.BLACK,
			Color.MAGENTA,Color.ORANGE};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建BufferedImage对象
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		//获得绘图对象
		Graphics g = image.getGraphics();
		//设置背景颜色
		g.setColor(Color.GRAY);
		//填充颜色
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//验证码数组
		char[]codes = new char[4];
		Random random = new Random();
		//设置字体
		g.setFont(new Font("宋体", Font.PLAIN, 20));
		//绘制随机的字母和数字
		for(int i=0;i<codes.length;i++) {
			codes[i] = CODES.charAt(random.nextInt(CODES.length()));
			//设置颜色
			g.setColor(COLOR[random.nextInt(COLOR.length)]);
			//绘制文字
			g.drawString(codes[i]+"", 5+i*20, 25);
			//绘制横线
			g.setColor(COLOR[random.nextInt(COLOR.length)]);
			g.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
					random.nextInt(WIDTH), random.nextInt(WIDTH));
		}
		//在Session中保存验证码
		req.getSession().setAttribute("vcode", new String(codes));
		ImageIO.write(image, "png", resp.getOutputStream());
	}
}
