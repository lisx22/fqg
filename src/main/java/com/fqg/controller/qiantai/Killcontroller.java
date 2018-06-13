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
@RequestMapping("kill")
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

        return "秒杀中";
    }
    @RequestMapping("allkill")
    public Object allKillCommodities(HttpSession  model){
        Customer customer = (Customer)model.getAttribute("customer");
        model.setAttribute("allkill",killCommodityServie.allKillCommodity());
        return redisUtil.get("allkillCommodities");
    }
    @RequestMapping("killinfo")
    public String killInfo(Model model,String killid){
        model.addAttribute("killinfo",killCommodityServie.killCommodity(killid));
        return "";
    }
    @RequestMapping("returnkill")
    @ResponseBody
    public String returnKill(String killid, HttpSession model){
        Customer customer = (Customer)model.getAttribute("customer");
        Object o= redisUtil.get("kill"+customer.getCustomerId()+killid);
        if (o != null){
            if(o.toString().equals(1)){

                return "秒杀成功";
            }else {
                return "秒杀失败";
            }
        }else{
            return "0";
        }
    }
}
