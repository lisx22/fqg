package com.fqg.controller.manager;

import com.fqg.entity.BlackCustomer;
import com.fqg.entity.Customer;
import com.fqg.service.manager.impl.BlackCustomerServiceImpl;
import com.fqg.service.manager.impl.CustomerServiceImpl;
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
@RequestMapping("/blackCustomer")
public class BlackCustomerController {

    static String getdata(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        return sdf.format(date);
    }

    @Resource
    private BlackCustomerServiceImpl blackCustomerService;

    @Resource
    private CustomerServiceImpl customerService;

    @RequestMapping(value="/blackCustomerList/{first}", method = RequestMethod.GET)
    public String list(@PathVariable("first")int first, Model model){
        List<BlackCustomer> blackCustomerlist = blackCustomerService.selectByPage(first);
        int pageCount = blackCustomerService.selectCount();
        model.addAttribute("blackCustomerlist",blackCustomerlist);
        model.addAttribute("first",first);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("pageSize",blackCustomerlist.size());
        return "html/gl_blackCustomer.ftl";
    }

    @RequestMapping("/preAdd")
    public String preAdd(){
        return "html/gl_blackCustomer_add.ftl";
    }

    @RequestMapping("/add")
    public String add(BlackCustomer blackCustomer, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<BlackCustomer> list1 = blackCustomerService.selectByID(blackCustomer.getIdNumber());
        List<Customer> list2 = customerService.selectByID(blackCustomer.getIdNumber());
        if(list1.isEmpty() && !list2.isEmpty()){
            blackCustomer.setCreateTime(getdata());
            blackCustomerService.insert(blackCustomer);
        }else{
            if(list1==null){
                System.out.println(11111);
            }else if(list2!=null){
                System.out.println(22222);
            }
        }
        return "redirect:/blackCustomer/blackCustomerList/0";
    }

    @RequestMapping(value="/deletes/", method = RequestMethod.POST)
    public String delete(@RequestParam(value="blackCustomerIds",required = false)List<Integer> blackCustomerIds, Model model) throws Exception{
        if(blackCustomerIds==null){
            return "redirect:/blackCustomer/blackCustomerList/0";
        }else{
            for (int id :blackCustomerIds ) {
                blackCustomerService.deleteByPrimaryKey(id);
            }
            return "redirect:/blackCustomer/blackCustomerList/0";
        }
    }

    @RequestMapping(value="/deleteById/{blackCostomerId}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("blackCostomerId") int blackCostomerId, Model model){
        System.out.println("deleteById");
        blackCustomerService.deleteByPrimaryKey(blackCostomerId);
        return "redirect:/blackCustomer/blackCustomerList/0";
    }
}
