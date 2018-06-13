package com.fqg.controller.manager;

import com.fqg.entity.Brand;
import com.fqg.entity.Commodity;
import com.fqg.entity.TypeOne;
import com.fqg.service.manager.impl.CommodityServiceImpl;
import com.fqg.util.SolrUtil;
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
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    private CommodityServiceImpl commodityService;

    private SolrUtil solrUtil = new SolrUtil();

    static String getdata(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        return sdf.format(date);
    }

    @RequestMapping(value="/commodityList/{first},{typeOneId}", method = RequestMethod.GET)
    public String commodityList(@PathVariable("first")int first,@PathVariable("typeOneId")int typeOneId,Model model){

        List<Commodity> CommodityList =  commodityService.selectByPage(typeOneId,first);
        if(CommodityList==null){
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
        return "html/gl_commodity.ftl";
    }

    @RequestMapping("/preAdd")
    public String preAdd(Model model){
        List<TypeOne> typeones = commodityService.selectTypeOne();
        List<TypeOne> typetwos = commodityService.selectTypeTwo();
        List<TypeOne> typethrees = commodityService.selectTypeThree();
        List<Brand> Brands = commodityService.selectBrand();
        model.addAttribute("typeones",typeones);
        model.addAttribute("typetwos",typetwos);
        model.addAttribute("typethrees",typethrees);
        model.addAttribute("Brands",Brands);
        return "html/gl_commodity_add.ftl";
    }

    @RequestMapping("/add")
    public String add(Commodity commodity, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        commodity.setCreateTime(getdata());
        commodity.setUpdateTime(getdata());
        commodity.setCommodityStatus(1);
        commodityService.insert(commodity);
        //solr服务器添加field
        int id = commodityService.selectBycommodityName(commodity.getCommodityName()).getCommodityId();
        solrUtil.addDocument(id,commodity.getCommodityName());
        return "redirect:/commodity/commodityList/0,1";
    }

    @RequestMapping(value="/deletes/", method = RequestMethod.POST)
    public String delete(@RequestParam(value="commodityIds",required = false)List<Integer> commodityIds, Model model) throws Exception{
        if(commodityIds==null){
            return "redirect:/commodity/commodityList/0,1";
        }else{
            for (int id :commodityIds) {
                commodityService.deleteByPrimaryKey(id);
            }
            return"redirect:/commodity/commodityList/0,1";
        }
    }

    @RequestMapping(value="/deleteById/{commodityId}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("commodityId") int commodityId, Model model){
        commodityService.deleteByPrimaryKey(commodityId);
//删除solr上的数据
        solrUtil.deleteDocumentByQuery(commodityId);
        return"redirect:/commodity/commodityList/0,1";
    }


    @RequestMapping(value="/preUpdateCommodity/{commodityId}", method = RequestMethod.GET)
    public String preUpdateCustomer(@PathVariable("commodityId")int commodityId, Model model){
        Commodity commodity = commodityService.selectByPrimaryKey(commodityId);
        model.addAttribute("commodity",commodity);
        return "html/gl_commodity_update.ftl";
    }

    @RequestMapping("/update")
    public String updateCustomer(Commodity commodity, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //solr服务器修改field 也是调用update方法
        int id = commodityService.selectBycommodityName(commodity.getCommodityName()).getCommodityId();
        solrUtil.addDocument(id,commodity.getCommodityName());

        commodity.setUpdateTime(getdata());
        commodityService.updateByPrimaryKey(commodity);
        return"redirect:/commodity/commodityList/0,1";
    }

}
