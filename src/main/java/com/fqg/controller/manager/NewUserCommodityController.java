package com.fqg.controller.manager;

import com.fqg.entity.Commodity;
import com.fqg.entity.KillCommodity;
import com.fqg.entity.NewUserCommodity;
import com.fqg.service.manager.CommodityService;
import com.fqg.service.manager.NewUserCommodityService;
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
@RequestMapping("/newUserCommodity")
public class NewUserCommodityController {
    @Resource
    private NewUserCommodityService newUserCommodityService;

    @Resource
    private CommodityService commodityService;

    static String getdata(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        return sdf.format(date);
    }

    @RequestMapping(value="/newUserCommodityList/{first}", method = RequestMethod.GET)
    public String customerList(@PathVariable("first")int first, Model model){
        List<NewUserCommodity> newUserCommodityList =  newUserCommodityService.selectByPage(first);
        int pageCount = newUserCommodityService.selectCount();
        model.addAttribute("newUserCommodityList",newUserCommodityList);
        model.addAttribute("first",first);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pageSize",newUserCommodityList.size());
        return "html/gl_newUserCommodity";
    }
    @RequestMapping("/preAdd")
    public String preAdd(){
        return"html/gl_newUserCommodity_add";
    }

    @RequestMapping("/add")
    public String add(NewUserCommodity newUserCommodity, HttpServletRequest req){

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Commodity commodity2 = commodityService.selectByPrimaryKey(newUserCommodity.getCommodityId());
        if(commodity2!=null) {
            newUserCommodity.setCreateTime(getdata());
            newUserCommodity.setUpdateTime(getdata());
            newUserCommodityService.insert(newUserCommodity);
        }
        return "redirect:/newUserCommodity/newUserCommodityList/0";
    }

    @RequestMapping(value="/preUpdate/{killCommodityId}", method = RequestMethod.GET)
    public String preUpdateCommodity(@PathVariable("killCommodityId")int killCommodityId, Model model){
        NewUserCommodity newUserCommodity = newUserCommodityService.selectByPrimaryKey(killCommodityId);
        model.addAttribute("newUserCommodity",newUserCommodity);
        return "html/gl_newUserCommodity_update";
    }

    @RequestMapping("/update")
    public String updateKillCommodity(NewUserCommodity newUserCommodity, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        newUserCommodity.setUpdateTime(getdata());
        newUserCommodityService.updateByPrimaryKey(newUserCommodity);
        return "redirect:/newUserCommodity/newUserCommodityList/0";
    }

    @RequestMapping(value="/deletes/", method = RequestMethod.POST)
    public String delete(@RequestParam(value="newUserCommodityIds",required = false)List<Integer> newUserCommodityIds, Model model) throws Exception{
        if(newUserCommodityIds!=null){
            for (int id :newUserCommodityIds ) {
                newUserCommodityService.deleteByPrimaryKey(id);
            }
        }
        return "redirect:/newUserCommodity/newUserCommodityList/0";
    }

    @RequestMapping(value="/deleteById/{newUserCommodityId}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("newUserCommodityId") int newUserCommodityId, Model model){
        System.out.println(newUserCommodityId);
        newUserCommodityService.deleteByPrimaryKey(newUserCommodityId);
        return "redirect:/newUserCommodity/newUserCommodityList/0";
    }

}
