package com.fqg.controller.manager;

import com.fqg.entity.Customer;
import com.fqg.service.manager.impl.CustomerServiceImpl;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerServiceImpl customerService;

    @RequestMapping(value="/customerList/{first}", method = RequestMethod.GET)
    public String customerList(@PathVariable("first")int first, Model model){

        List<Customer> Customerlist =  customerService.selectByPage(first);
        model.addAttribute("Customerlist",Customerlist);
         return "html/gl_user";
    }

    @RequestMapping("/preAdd")
    public String preAdd(){
        return"html/gl_user_add";
    }

    @RequestMapping("/add")
    public String add(Customer customer, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        customer.setQuota(customer.getAllQuota());
        System.out.println(customer.toString());
        customerService.insert(customer);

        return "redirect:/customer/customerList/0";
    }

}
