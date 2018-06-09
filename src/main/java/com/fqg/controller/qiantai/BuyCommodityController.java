package com.fqg.controller.qiantai;

import com.fqg.entity.Commodity;
import com.fqg.entity.CommodityCoupon;
import com.fqg.service.qiantai.IBeforeAddOrderService;
import com.fqg.service.qiantai.ICommodityCoupon;
import com.fqg.service.qiantai.impl.BeforeAddOrderService;
import com.fqg.service.qiantai.impl.CommodityCouponService;
import com.fqg.service.qiantai.impl.CommodityInfoService;
//import com.fqg.service.qiantai.impl.Producer;
import com.fqg.service.qiantai.impl.Producer;
import com.fqg.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
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
    @Autowired
    private Producer producer;


    /**
     * @Description: 消息队列
     * @Author:
     * @CreateTime:
     */
    @Autowired
    RedisUtil redisUtil;
    @ResponseBody
    @RequestMapping("/sendQueue")
    public String testQueue() {
        try {
            String queueId = "test_queue";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", "hello rabbitmq");
            // 注意：第二个属性是 Queue 与 交换机绑定的路由
            producer.sendQueue("test_mq_exchange" , "test_mq_patt", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(redisUtil.get("消息消费者"));
        return "发送完毕";
    }

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
    public String addToLikeCommodity(String commodityId,String customerId){
        return "";
    }
}
