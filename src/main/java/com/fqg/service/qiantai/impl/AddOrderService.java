package com.fqg.service.qiantai.impl;

import com.alibaba.fastjson.JSON;
import com.fqg.dao.CommodityMapper;
import com.fqg.dao.OrdersMapper;
import com.fqg.dao.RepayMapper;
import com.fqg.entity.*;
import com.fqg.service.qiantai.IAddOrderService;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 将商品加入订单表，更新用户表数据，还款信息新增，
 * @author zhj
 * @time 2018/6/7
 */
@Service
@Transactional
public class AddOrderService implements IAddOrderService{
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private RepayMapper repayMapper;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean addToOrder(Orders orders) {
        Gson gson = new Gson();
        //查询该商品数据
        Commodity commodity = new Commodity();
        String str = "";
        //在缓存中查询商品信息
        if(redisUtil.get("commoditya"+orders.getCommodityId()) == null) {
            commodity = commodityMapper.selectByPrimaryKey(orders.getCommodityId());
            str = gson.toJson(commodity);
            //将查询出来的数据存入缓存
            redisUtil.set("commoditya" + orders.getCommodityId(),str);
        }else {
            str = redisUtil.get("commoditya"+orders.getCommodityId()).toString();
        }
        commodity = JSON.parseObject(str,Commodity.class);
        //计算商品库存是否足够
        int num = commodity.getNumber() - orders.getNumber();
        int sallNum = commodity.getSellNum() + orders.getNumber();
        if (num >= 0){
            //库存住够则修改商品对象数据并跟新至数据库
            commodity.setNumber(num);
            commodity.setSellNum(sallNum);
            commodityMapper.updateByPrimaryKey(commodity);
            //向订单表插入数据
            ordersMapper.insert(orders);
            //完善还款表信息向还款表中插入信息
            Repay repay = new Repay();
            //用户id
            repay.setCustomerId(orders.getCustomerId());
            //还款月数
            repay.setPaidStage(0);
            //未还月数
            repay.setUnpadiStage(orders.getStage());
            //当月应还
            repay.setWillPayAmount(orders.getPayMoney()/orders.getStage());
            //订单id
            repay.setOrderId(ordersMapper.selectByNum(orders.getOrderNum()));
            repayMapper.insert(repay);
        }else {
            return false;
        }
        return true;
    }
}
