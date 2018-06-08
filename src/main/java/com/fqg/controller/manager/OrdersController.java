package com.fqg.controller.manager;

import com.fqg.entity.Orders;
import com.fqg.service.manager.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrderService orderService;

    static String getdata(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        return sdf.format(date);
    }

    @RequestMapping(value="/ordersList/{first}", method = RequestMethod.GET)
    public String ordersList(@PathVariable("first")int first, Model model){
        List<Orders> orderslist =  orderService.selectByPage(first);
        int pageCount = orderService.selectCount();
        model.addAttribute("orderslist",orderslist);
        model.addAttribute("first",first);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pageSize",orderslist.size());
        return "html/gl_orders";
    }




}
