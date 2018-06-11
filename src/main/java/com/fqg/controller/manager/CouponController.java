package com.fqg.controller.manager;

import com.fqg.entity.*;
import com.fqg.service.manager.impl.CouponServiceImpl;
import com.fqg.util.utilClasses.Coupon;
import com.fqg.util.utilClasses.CouponList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Controller
@RequestMapping("/coupon")
public class CouponController {
    @Resource
    private CouponServiceImpl couponService;

    private static Coupon coupon = new Coupon();

    @RequestMapping(value="/couponList/{type}", method = RequestMethod.GET)
    public String couponList(@PathVariable("type")int type, Model model){
        CouponList couponList = couponService.selectByPage();
        System.out.println("coupon");
        switch (type){
            case 1:
                model.addAttribute("CouponList",couponList.getList1());
                model.addAttribute("ListType",1);
                model.addAttribute("typeName","利息优惠券");
                break;
            case 2:
                model.addAttribute("CouponList",couponList.getList2());
                model.addAttribute("ListType",2);
                model.addAttribute("typeName","价格优惠券");
                break;
            case 3:
                model.addAttribute("CouponList",couponList.getList3());
                model.addAttribute("ListType",3);
                model.addAttribute("typeName","类型利息优惠券");
                break;
            case 4:
                model.addAttribute("CouponList",couponList.getList4());
                model.addAttribute("ListType",4);
                model.addAttribute("typeName","类型价格优惠券");
                break;
        }

        return "html/gl_coupon.jsp";
    }

    @RequestMapping(value="/preAdd/{type}", method = RequestMethod.GET)
    public String preAdd(@PathVariable("type")int type, Model model){
        model.addAttribute("ListType",type);
        return"html/gl_coupon_add.jsp";
    }

    @RequestMapping("/add1")
        public String add(AllInterestCoupon allinterestcoupon, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       coupon.setAllInterestCoupon(allinterestcoupon);
        couponService.insert(coupon);
        return "redirect:couponList/2";
    }

    @RequestMapping("/add2")
    public String add(AllPriceCoupon allpricecoupon, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        coupon.setAllPriceCoupon(allpricecoupon);
        couponService.insert(coupon);
        return "redirect:couponList/1";
    }

    @RequestMapping("/add3")
    public String add(TypeInterestCoupon interestCoupon, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        coupon.setTypeInterestCoupon(interestCoupon);
        couponService.insert(coupon);
        return "redirect:couponList/3";
    }

    @RequestMapping("/add4")
    public String add(TypePriceCoupon typePriceCoupon, HttpServletRequest req){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        coupon.setTypePriceCoupon(typePriceCoupon);
        couponService.insert(coupon);
        return "redirect:couponList/4";
    }

    @RequestMapping(value="/deleteById/{couponId},{ListType}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("couponId") int couponId,@PathVariable("ListType") int ListType){
        System.out.println("deleteById");
        couponService.deleteById(couponId,ListType);
        return "redirect:couponList/"+ListType;
    }


}
