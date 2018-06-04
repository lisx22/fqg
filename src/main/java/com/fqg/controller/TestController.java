package com.fqg.controller;


import com.fqg.service.TestService;
import com.fqg.service.impl.TestServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestServiceImpl testService;

    @RequestMapping("/cs")
    public String queryOrder(){
         testService.test();
        System.out.println("haha");
        return "123";
    }

//    @ResponseBody
//    @RequestMapping("/cs")
//    public Object test(){
//        return "ce shi";
//    }
}
