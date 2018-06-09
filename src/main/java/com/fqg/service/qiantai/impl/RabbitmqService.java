package com.fqg.service.qiantai.impl;
import com.alibaba.fastjson.JSONObject;
import com.fqg.dao.KillCommodityMapper;
import com.fqg.dao.OrdersMapper;
import com.fqg.dao.RepayMapper;
import com.fqg.entity.Customer;
import com.fqg.entity.KillCommodity;
import com.fqg.entity.Orders;
import com.fqg.entity.Repay;
import com.fqg.util.RedisUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 秒杀消费者
 * @author zhj
 * @time 2018/6/9
 */
public class RabbitmqService implements MessageListener {
    @Autowired
    RedisUtil redisUtil;
    @Resource
    KillCommodityMapper killCommodityMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private RepayMapper repayMapper;
    public void onMessage(Message message) {
       String[] str =  message.toString().split("-fgf-");
        Customer customer = JSONObject.parseObject(str[0],Customer.class);
        int kuchun = Integer.parseInt(redisUtil.get("kill"+str[1]).toString());
        if(kuchun > 0){
            redisUtil.set("kill"+str[1],kuchun-1);
            KillCommodity killCommodity = killCommodityMapper.selectByPrimaryKey(Integer.parseInt(str[1]));
            Orders orders = new Orders();
            orders.setNumber(1);
            orders.setPayMoney(killCommodity.getPrice());
            orders.setCustomerId(customer.getCustomerId());
            orders.setCommodityId(killCommodity.getCommodityId());
            orders.setOrderState(1);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMddHHss");
            orders.setOrderNum(Integer.parseInt(sdf1.format(d)));
            orders.setCreateTime(sdf.format(d));
            orders.setStage(12);
            int num = killCommodity.getNumber() - orders.getNumber();
            if (num >= 0){
                //库存住够则修改商品对象数据并跟新至数据库
                killCommodity.setNumber(num);
                killCommodityMapper.updateByPrimaryKey(killCommodity);
                //向订单表插入数据
                ordersMapper.insert(orders);
                //完善还款表信息向还款表中插入信息
                Repay repay = new Repay();
                //用户id
                repay.setCustomerId(orders.getCustomerId());
                //还款月数
                repay.setPaidStage(0);
                //逾期月数
                repay.setUnpadiStage(0);
                //当月应还
                repay.setWillPayAmount(orders.getPayMoney()/orders.getStage());
                //订单id
                repay.setOrderId(ordersMapper.selectByNum(orders.getOrderNum()));
                repayMapper.insert(repay);
                redisUtil.set("kill"+customer.getCustomerId()+killCommodity.getKillCommodityId(),1);
            }else {
                redisUtil.set("kill"+customer.getCustomerId()+killCommodity.getKillCommodityId(),0);
            }
        }
       redisUtil.set("消息消费者","haha");
    }
}