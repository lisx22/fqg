package com.fqg.controller.qiantai;

import com.fqg.util.wuLiu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 物流查询
 * @author zhj
 * @time 2018/6/12
 */
@Controller
@RequestMapping("/wuliu")
public class WuLiuController {

    @RequestMapping("/")
    public String wuliu(Model model,String danhao,String kd){
        wuLiu wuLiu = new wuLiu();
        String str = wuLiu.wuliu(kd,danhao);
        return str;
    }
}
