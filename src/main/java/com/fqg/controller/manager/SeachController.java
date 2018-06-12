package com.fqg.controller.manager;

import com.fqg.entity.Commodity;
import com.fqg.entity.TypeOne;
import com.fqg.service.manager.impl.CommodityServiceImpl;
import com.fqg.util.SolrUtil;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/seach")
public class SeachController {

    private SolrUtil solrUtil = new SolrUtil();

    @Resource
    private CommodityServiceImpl commodityService;

    @RequestMapping(value = "/commodity", method = RequestMethod.GET)
    public String seachCommodity(String keyword, Model model){
        System.out.println(keyword);
        List<TypeOne> types = commodityService.selectTypeOne();
//        SolrDocumentList solrDocuments = solrUtil.queryIndex(keyword);
//        System.out.println(solrDocuments.toString());
        ArrayList<Commodity> CommodityList = new ArrayList<>();
//        for (SolrDocument solrDocument : solrDocuments){
//            Commodity commodity = commodityService.selectByPrimaryKey(Integer.parseInt(solrDocument.get("commodityId").toString()));
            CommodityList.add(commodityService.selectByPrimaryKey(4));
//        }

        model.addAttribute("CommodityList",CommodityList);
        model.addAttribute("first",0);
        model.addAttribute("pageCount",1);
        model.addAttribute("pageSize",CommodityList.size());
        model.addAttribute("types",types);
        return "html/gl_commodity.ftl";

    }
}
