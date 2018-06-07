package com.fqg.controller.qiantai;

import com.fqg.entity.CommoditySelect;
import com.fqg.entity.CommoditySmallVO;
import com.fqg.entity.PageInfo;
import com.fqg.service.qiantai.ICommoditySearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/7
 * @Time 20:23
 */
@Controller
@RequestMapping("/selectCommodity")
public class SelectCommodityController {

    @Resource
    private ICommoditySearchService iCommoditySearchService;

    @RequestMapping("/select")
    public String select(Model model,String pageNo,
                         CommoditySelect commoditySelect){
        if(pageNo==null){
            pageNo="1";
        }
        PageInfo<CommoditySmallVO> pageInfo = iCommoditySearchService.
                selectByCommoditySelect(commoditySelect, Integer.parseInt(pageNo));
        model.addAttribute("pageInfo",pageInfo);
        return "";
    }
}
