package com.fqg.controller.qiantai;

import com.alibaba.fastjson.JSON;
import com.fqg.entity.Traces;
import com.fqg.entity.WuLiuInfo;
import com.fqg.util.WuLiu.FegineApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 物流查询
 * @author zhj
 * @time 2018/6/12
 */
@Controller
@RequestMapping("/wuliu")
public class WuLiuController {

    @RequestMapping("/to")
    public String to(Model model){
        String string = FegineApi.getwuliu();
        WuLiuInfo wuLiuInfo = JSON.parseObject(string, WuLiuInfo.class);
        System.out.println(wuLiuInfo);
        List<Traces> traces = wuLiuInfo.getTraces();
        model.addAttribute("traces",traces);
        return "wuliu.ftl";
    }

}
