package com.fqg.controller.qiantai;

import com.fqg.entity.Commodity;
import com.fqg.service.qiantai.impl.CommodityInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    //商品详情接口
    @RequestMapping("/commodityinfo")
    @ResponseBody
    public Object commodityInfo(String id){
        return infoService.commodityInfo(Integer.parseInt(id));
    }
//    @RequestMapping("")
}
