package com.fqg.controller.manager;

import com.fqg.entity.Brand;
import com.fqg.entity.Commodity;
import com.fqg.entity.TypeOne;
import com.fqg.service.manager.impl.CommodityServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    private CommodityServiceImpl commodityService;

    @RequestMapping(value="/commodityList/{first},{typeOneId}", method = RequestMethod.GET)
    public String customerList(@PathVariable("first")int first,@PathVariable("typeOneId")int typeOneId,Model model){
        System.out.println("first"+first);
        List<Commodity> CommodityList =  commodityService.selectByPage(typeOneId,first);
        if(CommodityList==null){
//            CommodityList = new ArrayList<Commodity>();
//            model.addAttribute("CommodityList",CommodityList);
//            model.addAttribute("pageCount",0);
//            return "html/gl_commodity";
        }
        int pageCount = commodityService.selectCount(typeOneId);
        List<TypeOne> types = commodityService.selectTypeOne();
        String typeName = commodityService.selectTypeName(typeOneId).getTypeOneName();
        model.addAttribute("CommodityList",CommodityList);
        model.addAttribute("first",first);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pageSize",CommodityList.size());
        model.addAttribute("types",types);
        model.addAttribute("typeOneId",typeOneId);
        model.addAttribute("typeName",typeName);
        System.out.println(CommodityList.get(0).getCommodityName());
        return "html/gl_commodity";
    }

    @RequestMapping("/preAdd")
    public String preAdd(Model model){
        List<TypeOne> typeones = commodityService.selectTypeOne();
        List<TypeOne> typetwos = commodityService.selectTypeTwo();
        List<TypeOne> typethrees = commodityService.selectTypeThree();
        List<Brand> Brands = commodityService.selectBrand();
        System.out.println(typeones.size()+typetwos.size()+typethrees.size()+Brands.size());
        model.addAttribute("typeones",typeones);
        model.addAttribute("typetwos",typetwos);
        model.addAttribute("typethrees",typethrees);
        model.addAttribute("Brands",Brands);
        return"html/gl_commodity_add";
    }

    @RequestMapping("/add")
    public String add(Commodity commodity, HttpServletRequest req){
        System.out.println("add");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        commodity.setCreateTime(sdf.format(date));
        commodity.setUpdateTime(sdf.format(date));
        commodity.setCommodityStatus(1);
        commodityService.insert(commodity);
        return "redirect:/commodity/commodityList/0,1";
    }

}
