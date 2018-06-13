package com.fqg.controller.manager;

import com.fqg.entity.Commodity;
import com.fqg.entity.TypeOne;
import com.fqg.service.manager.impl.CommodityServiceImpl;
import com.fqg.util.KeyWord;
import com.fqg.util.SolrUtil;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/seach")
public class SeachController {

    private SolrUtil solrUtil = new SolrUtil();

    @Resource
    private CommodityServiceImpl commodityService;

    @RequestMapping("/commodity")
    public String seachCommodity(KeyWord word, Model model, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String keyword = word.getWord();
        List<TypeOne> types = commodityService.selectTypeOne();
        SolrDocumentList solrDocuments = solrUtil.queryIndex(keyword);
        ArrayList<Commodity> CommodityList = new ArrayList<>();
        for (SolrDocument solrDocument : solrDocuments){
            Commodity commodity = commodityService.selectByPrimaryKey(Integer.parseInt(solrDocument.get("commodityId").toString()));
            CommodityList.add(commodityService.selectByPrimaryKey(commodity.getCommodityId()));
        }
        model.addAttribute("CommodityList",CommodityList);
        model.addAttribute("first",0);
        model.addAttribute("pageCount",1);
        model.addAttribute("pageSize",CommodityList.size());
        model.addAttribute("types",types);
        model.addAttribute("typeOneId",1);
        model.addAttribute("typeName","search");
        return "html/gl_commodity.ftl";
    }
}
