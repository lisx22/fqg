package com.fqg.controller.qiantai;

import com.fqg.entity.Customer;
import com.fqg.service.qiantai.impl.KillCommodityServie;
import com.fqg.service.qiantai.impl.Producer;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/kill")
public class Killcontroller {
    @Resource
    private Producer producer;
    /**
     * @Description: 消息队列
     * @Author:
     * @CreateTime:
     */
    @Autowired
    RedisUtil redisUtil;
    @Resource
    private KillCommodityServie killCommodityServie;
    @RequestMapping("/kill")
    @ResponseBody
    public String testQueue(HttpSession model, String killid) {
        System.out.println(killid+"Th");
        Customer customer = (Customer)model.getAttribute("customer");
        try {
            String str =new Gson().toJson(customer);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", str+"-fgf-"+killid);
            // 注意：第二个属性是 Queue 与 交换机绑定的路由
            producer.sendQueue("test_mq_exchange" , "test_mq_patt", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }
    @RequestMapping("/allkill")
    public Object allKillCommodities(HttpSession  httpSession,Model model){
        Customer customer = (Customer)httpSession.getAttribute("customer");
        model.addAttribute("allkill",killCommodityServie.allKillCommodity());
        return "Seckill.ftl";
    }
//    点击购买加循环
    @RequestMapping("/killinfo")
    public String killInfo(Model model,String killid){
        model.addAttribute("killinfo",killCommodityServie.killCommodity(killid));
        System.out.println(killid+"=="+killCommodityServie.killCommodity(killid));
        return "Seckill_2.ftl";
    }
    @RequestMapping("/returnkill")
    @ResponseBody
    public String returnKill(String killid, HttpSession model){
        Customer customer = (Customer)model.getAttribute("customer");
        Object o= redisUtil.get("kill"+customer.getCustomerId()+killid);
        if (o != null){
            if(o.toString().equals("1")){
                redisUtil.del("kill"+customer.getCustomerId()+killid);
                return "1";

            }else {
                return "2";
            }
        }else{
            return "0";
        }
    }
}
