package com.fqg.controller.qiantai;

import com.fqg.entity.*;
import com.fqg.service.qiantai.IBeforeAddOrderService;
import com.fqg.service.qiantai.ICommodityCoupon;
import com.fqg.service.qiantai.impl.*;
//import com.fqg.service.qiantai.impl.Producer;
import com.fqg.util.EasyGoUtil;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import javafx.scene.media.SubtitleTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购买相关controller
 * @author zhj
 * @time 2018.6.5
 */
@Controller
@RequestMapping("/buy")
public class BuyCommodityController {
    @Resource
    private CommodityInfoService infoService;
    @Resource
    private CommodityCouponService iCommodityCoupon;
    @Resource
    private BeforeAddOrderService iBeforeAddOrderService;
    @Resource
    private Producer producer;
    @Resource
    private AddLikeCommodity addLikeCommodity;
    @Resource
    private AddToCartService addToCartService;


    //商品详情接口
    @RequestMapping("/commodityinfo")
    public String commodityInfo(String id, Model model,HttpServletRequest httpSession){
        Commodity commodity = infoService.commodityInfo(Integer.parseInt(id));
        CommodityCoupon commodityCoupon = iCommodityCoupon.coupon(commodity.getOneTypeId(),commodity.getCommodityPrice());
//       内存
        String price_ = httpSession.getParameter("price_");
        httpSession.getSession().setAttribute("price",price_);
        model.addAttribute("coupon",commodityCoupon);
//        显示详情
        model.addAttribute("commodityInfo",commodity);
        return "Buy.ftl";
    }
    //购买商品，加入订单表
    @RequestMapping("/addorder")
    @ResponseBody
    public String addToOrder(String buyInfo,Customer customer,Model model,HttpSession httpSession){
        customer =(Customer) httpSession.getAttribute("customer");
        if (customer == null) {
            return "1";
        }
        String str = iBeforeAddOrderService.addToOrder(customer,buyInfo);
        model.addAttribute("msg",str);
        //后台消息传递6
        new EasyGoUtil().easyGO();
        return "redirect:/repay/listOrder/";
    }
    //在购物车页面批量购买
    @RequestMapping("/alladdorder")
    public String allAddOrder(){
        return "";
    }
    //加入收藏夹
    @RequestMapping("/likecommodity")
    public String addToLikeCommodity(String commodityId,Customer customer,Model model){
        List<LikeCommodity> likeCommodities = addLikeCommodity.addLikeCommodity(customer,Integer.parseInt(commodityId));
        model.addAttribute("likeCommodities",likeCommodities);
        return "";
    }
    //加入购物车
    @RequestMapping("/addcart")
    public String addToCart(Customer customer,String str,Model model){

        List<Cart> carts = addToCartService.addToCart(customer,str);
        model.addAttribute("carts",carts);
        return "";
    }
}
