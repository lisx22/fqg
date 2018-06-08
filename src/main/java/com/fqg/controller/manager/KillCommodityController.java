package com.fqg.controller.manager;

import com.fqg.entity.Commodity;
import com.fqg.entity.Customer;
import com.fqg.entity.KillCommodity;
import com.fqg.service.manager.CommodityService;
import com.fqg.service.manager.KillCommodityService;
import com.fqg.service.manager.impl.KillCommodityServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/killCommodity")
public class KillCommodityController {
    @Resource
    private KillCommodityServiceImpl killCommodityService;

    @Resource
    private CommodityService commodityService;

    static String getdata(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        return sdf.format(date);
    }

    @RequestMapping(value="/killCommodityList/{first}", method = RequestMethod.GET)
    public String customerList(@PathVariable("first")int first, Model model){
        List<KillCommodity> KillCommodityList =  killCommodityService.selectByPage(first);
        int pageCount = killCommodityService.selectCount();
        model.addAttribute("KillCommodityList",KillCommodityList);
        model.addAttribute("first",first);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pageSize",KillCommodityList.size());
        return "html/gl_killCommodity";
    }

    @RequestMapping("/preAdd")
    public String preAdd(){
        return"html/gl_killCommodity_add";
    }

    @RequestMapping("/add")
    public String add(KillCommodity killCommodity, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Commodity commodity2 = commodityService.selectByPrimaryKey(killCommodity.getCommodityId());
        if(commodity2!=null) {
                killCommodity.setCreateTime(getdata());
                killCommodity.setUpdateTime(getdata());
                killCommodityService.insert(killCommodity);
        }
        return "redirect:/killCommodity/killCommodityList/0";
    }

    @RequestMapping(value="/preUpdateKillCommodity/{killCommodityId}", method = RequestMethod.GET)
    public String preUpdateCommodity(@PathVariable("killCommodityId")int killCommodityId, Model model){
        KillCommodity killCommodity = killCommodityService.selectByPrimaryKey(killCommodityId);
        model.addAttribute("killCommodity",killCommodity);
        return "html/gl_killCommodity_update";
    }

    @RequestMapping("/update")
    public String updateKillCommodity(KillCommodity killCommodity, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(killCommodity.getPrice()+"000");

        killCommodity.setUpdateTime(getdata());
        killCommodityService.updateByPrimaryKey(killCommodity);
        return "redirect:/killCommodity/killCommodityList/0";
    }

    @RequestMapping(value="/deletes/", method = RequestMethod.POST)
    public String delete(@RequestParam(value="killCommodityIds",required = false)List<Integer> killCommodityIds, Model model) throws Exception{
        if(killCommodityIds!=null){
            for (int id :killCommodityIds ) {
                killCommodityService.deleteByPrimaryKey(id);
            }
        }
        return "redirect:/killCommodity/killCommodityList/0";
    }

    @RequestMapping(value="/deleteById/{killCommodityId}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("killCommodityId") int killCommodityId, Model model){
        killCommodityService.deleteByPrimaryKey(killCommodityId);
        return "redirect:/killCommodity/killCommodityList/0";
    }
}
