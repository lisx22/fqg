package com.fqg.controller.manager;

import com.fqg.entity.Customer;
import com.fqg.service.manager.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

}
