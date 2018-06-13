package com.fqg.service.manager.impl;

import com.fqg.dao.AllInterestCouponMapper;
import com.fqg.dao.AllPriceCouponMapper;
import com.fqg.dao.TypeInterestCouponMapper;
import com.fqg.dao.TypePriceCouponMapper;
import com.fqg.entity.*;
import com.fqg.service.manager.CouponService;
import com.fqg.util.utilClasses.Coupon;
import com.fqg.util.utilClasses.CouponList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{
    @Resource
    private AllInterestCouponMapper allInterestCouponDAO;
    @Resource
    private AllPriceCouponMapper allPriceCouponDAO;
    @Resource
    private TypeInterestCouponMapper typeinterestCouponDAO;
    @Resource
    private TypePriceCouponMapper typePriceCouponDAO;

    public CouponList selectByPage(){
        List<AllInterestCoupon> list1 = allInterestCouponDAO.selectAll();
        List<AllPriceCoupon> list2 = allPriceCouponDAO.selectAll();
        List<TypeInterestCoupon> list3 = typeinterestCouponDAO.selectAll();
        List<TypePriceCoupon> list4 = typePriceCouponDAO.selectAll();
        CouponList couponList = new CouponList(list1,list2,list3,list4);
        return couponList;
    }

    public void insert(Coupon coupon){
        if(coupon.getAllInterestCoupon()!=null){
            allInterestCouponDAO.insert(coupon.getAllInterestCoupon());
        }
        if(coupon.getAllPriceCoupon()!=null){
            allPriceCouponDAO.insert(coupon.getAllPriceCoupon());
        }
        if(coupon.getTypeInterestCoupon()!=null){
            typeinterestCouponDAO.insert(coupon.getTypeInterestCoupon());
        }
        if(coupon.getTypePriceCoupon()!=null){
            typePriceCouponDAO.insert(coupon.getTypePriceCoupon());
        }
    }

    public void deleteById(int couponId,int typeId){
        switch (typeId){
            case 1:
                allInterestCouponDAO.deleteByPrimaryKey(couponId);
                break;
            case 2:
                allPriceCouponDAO.deleteByPrimaryKey(couponId);
                break;
            case 3:
                typeinterestCouponDAO.deleteByPrimaryKey(couponId);
                break;
            case 4:
                typePriceCouponDAO.deleteByPrimaryKey(couponId);
                break;
        }
    }


}
