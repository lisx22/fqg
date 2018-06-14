package com.fqg.controller.qiantai;

import com.fqg.entity.Customer;
import com.fqg.entity.OrderVO;
import com.fqg.service.qiantai.IOrderVOService;
import com.fqg.service.qiantai.IRepayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 9:41
 */
@Controller
@RequestMapping("/repay")
public class RepayController {

    @Resource
    private IRepayService repayService;

    @Resource
    private IOrderVOService orderVOService;

    @RequestMapping("/listOrder")
    public String listOrder(Model model, HttpSession httpSession){
        Customer customer = (Customer)httpSession.getAttribute("customer");
        List<OrderVO> orderVOList = orderVOService.selectByCustomer(customer.getCustomerId());
        model.addAttribute("orderVOList",orderVOList);
        return "order.ftl";
    }
}
