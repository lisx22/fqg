package com.fqg.controller.manager;

import com.fqg.entity.Customer;
import com.fqg.service.manager.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerServiceImpl customerService;

    static String getdata(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        return sdf.format(date);
    }

    @RequestMapping(value="/customerList/{first}", method = RequestMethod.GET)
    public String customerList(@PathVariable("first")int first, Model model){
        System.out.println("first"+first);
        List<Customer> Customerlist =  customerService.selectByPage(first);
        int pageCount = customerService.selectCount();
        model.addAttribute("Customerlist",Customerlist);
        model.addAttribute("first",first);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pageSize",Customerlist.size());
         return "html/gl_user.ftl";
    }

    @RequestMapping("/preAdd")
    public String preAdd(){
        return "html/gl_user_add.ftl";
    }

    @RequestMapping("/add")
    public String add(Customer customer, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        customer.setQuota(customer.getAllQuota());
        customerService.insert(customer);

        return "redirect:/customer/customerList/0";
    }

    @RequestMapping(value="/preUpdateCustomer/{costomerId}", method = RequestMethod.GET)
    public String preUpdateCustomer(@PathVariable("costomerId")int costomerId, Model model){
        Customer customer = customerService.selectByPrimaryKey(costomerId);
        model.addAttribute("customer",customer);
        return "html/gl_user_update.ftl";
    }

    @RequestMapping("/update")
    public String updateCustomer(Customer customer, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(customer.toString());
        customerService.updateByPrimaryKey(customer);
        return "redirect:/customer/customerList/0";
    }

    @RequestMapping(value="/deletes/", method = RequestMethod.POST)
    public String delete(@RequestParam(value="costomerIds",required = false)List<Integer> costomerIds, Model model) throws Exception{
        if(costomerIds==null){
            return "redirect:/customer/customerList/0";
        }else{
            for (int id :costomerIds ) {
                customerService.deleteByPrimaryKey(id);
            }
            return "redirect:/customer/customerList/0";
        }
    }

    @RequestMapping(value="/deleteById/{costomerId}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("costomerId") int costomerId, Model model){
        System.out.println("deleteById");
        customerService.deleteByPrimaryKey(costomerId);
        return "redirect:/customer/customerList/0";
    }

}
