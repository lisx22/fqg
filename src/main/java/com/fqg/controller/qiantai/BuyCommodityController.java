package com.fqg.controller.qiantai;

import com.fqg.entity.*;
import com.fqg.service.qiantai.IBeforeAddOrderService;
import com.fqg.service.qiantai.ICommodityCoupon;
import com.fqg.service.qiantai.impl.*;
//import com.fqg.service.qiantai.impl.Producer;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    public String commodityInfo(String id, Model model){
        Commodity commodity = infoService.commodityInfo(Integer.parseInt(id));
        CommodityCoupon commodityCoupon = iCommodityCoupon.coupon(commodity.getOneTypeId(),commodity.getCommodityPrice());
        model.addAttribute("coupon",commodityCoupon);
        model.addAttribute("commodityInfo",commodity);
        return "Buy";
    }
    //购买商品，加入订单表
    @RequestMapping("/addorder")
    public String addToOrder(String buyInfo){
        String str = iBeforeAddOrderService.addToOrder(buyInfo);
        return str;
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
