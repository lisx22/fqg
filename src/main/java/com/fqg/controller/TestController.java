package com.fqg.controller;


import com.fqg.service.impl.TestServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestServiceImpl testService;

    @ResponseBody
    @RequestMapping("/cs")
    public String queryOrder(){
         testService.test();
        System.out.println("haha");
        return "123";
    }

    @RequestMapping(value = "/testFreemarker")
    public ModelAndView getFirstPage(HttpServletRequest request) {
        //welcom就是视图的名称（welcom.ftl）
        ModelAndView mv = new ModelAndView("may");
        mv.addObject("name", "My First Spring Mvc and Freemarker !");
        return mv;
    }

//    @ResponseBody
//    @RequestMapping("/cs")
//    public Object test(){
//        return "ce shi";
//    }
}
