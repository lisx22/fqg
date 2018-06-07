package com.fqg.service.qiantai.impl;

import com.fqg.dao.*;
import com.fqg.entity.BuyInterest;
import com.fqg.entity.Customer;
import com.fqg.entity.Orders;
import com.fqg.service.qiantai.IBeforeAddOrderService;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 判断支付密码是否正确，查询商品价格判断余额是否足够支付
 * @author zhj
 * @time 20118/6/6
 */
@Service
public class BeforeAddOrderService implements IBeforeAddOrderService {
    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private AllInterestCouponMapper allInterestCouponMapper;
    @Resource
    private AllPriceCouponMapper allPriceCouponMapper;
    @Resource
    private CommodityColorMapper commodityColorMapper;
    @Resource
    private CommodityInfoMapper commodityInfoMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private BuyInterestMapper buyInterestMapper;
    @Resource
    private AddOrderService service;
    @Override
    public String addToOrder(String buyInfo) {
        //第一个值为商品id,第2个值为免息券id，第3个值为价格券id，第4个值为颜色id，第5个值为分期月数对应的利息id
        //第6个值为 用户id 第7个值为支付密码 第8个值为购买数量，其后值为详情id;
        //返回信息的字符串
        String str = "";
        //将客户端传递过来的值拆分为数组
        String[] infos = buyInfo.split("-");
        //根据用户id查询用户信息
        Customer customer = customerMapper.selectByPrimaryKey(Integer.parseInt(infos[5]));
        System.out.println(infos[6]);
        System.out.println(customer.getPayPassword());
        //判断支付密码是否正确（待修改为md5加密）正确则计算商品价格，不正确则返回支付密码错误
        if(infos[6].equals(customer.getPayPassword())){
            //查询商品初始价格
            int price = commodityMapper.selectPriceById(Integer.parseInt(infos[0]));
            //查询商品免息月数
            int allInterestCoupon = allInterestCouponMapper.selectByPrimaryKey(Integer.parseInt(infos[1])).getNointerestContent();
            //查询商品价格优惠
            int allPriceCoupon = allPriceCouponMapper.selectByPrimaryKey(Integer.parseInt(infos[2])).getReduceAmount();
            //查询颜色折价
            int colorPrice = commodityColorMapper.selectPriceByCommodityIdAndColorId(Integer.parseInt(infos[0]),Integer.parseInt(infos[3]));
            //查询分期利息
            BuyInterest buyInterest = buyInterestMapper.selectByPrimaryKey(Integer.parseInt(infos[4]));
            double fqqs = buyInterest.getPercent();
            // 查询详情折价
            int infoPrice = 0;
            for (int i = 8;i < infos.length;i++){
                System.out.println(commodityInfoMapper.selectPriceByCommodityIdAndInfoId(Integer.parseInt(infos[0]),Integer.parseInt(infos[i])));
                infoPrice += commodityInfoMapper.selectPriceByCommodityIdAndInfoId(Integer.parseInt(infos[0]),Integer.parseInt(infos[i]));
            }
            //购买数量
            int buyNum = Integer.parseInt(infos[7]);
            // 计算应付价格
            double buyPrice = (price + colorPrice + infoPrice -allPriceCoupon) * (1+fqqs) * buyNum;
            //判断应付价格与可用余额的对比 若可以支付则调用addOrder纯入订单和还款表 若不能支付则返回可用额度不够
            if (buyPrice < customer.getQuota()){
                Orders orders = new Orders();
                orders.setCommodityId(Integer.parseInt(infos[0]));
                orders.setCustomerId(customer.getCustomerId());
                orders.setPayMoney((int)buyPrice);
                orders.setStage(buyInterest.getStage());
                orders.setOrderState(1);
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHH");
                orders.setNumber(buyNum);
                orders.setOrderNum(Integer.parseInt(sdf1.format(d)));
                orders.setCreateTime(sdf.format(d));
                Gson gson = new Gson();
                System.out.println(gson.toJson(orders));
                boolean b = service.addToOrder(orders);
            }else{
                    str = "可以额度不够";
            }
        }else {
            str = "支付密码错误";
        }
        return str;
    }
}
