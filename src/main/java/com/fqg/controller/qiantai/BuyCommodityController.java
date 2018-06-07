package com.fqg.controller.qiantai;

import com.fqg.entity.Commodity;
import com.fqg.entity.CommodityCoupon;
import com.fqg.service.qiantai.impl.CommodityCouponService;
import com.fqg.service.qiantai.impl.CommodityInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

        return "";
    }
}
