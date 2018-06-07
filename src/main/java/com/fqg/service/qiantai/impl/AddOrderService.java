package com.fqg.service.qiantai.impl;

import com.fqg.dao.CommodityMapper;
import com.fqg.dao.OrdersMapper;
import com.fqg.dao.RepayMapper;
import com.fqg.entity.Commodity;
import com.fqg.entity.Orders;
import com.fqg.entity.Repay;
import com.fqg.service.qiantai.IAddOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AddOrderService implements IAddOrderService{
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private RepayMapper repayMapper;
    public boolean addToOrder(Orders orders) {

        Commodity commodity = commodityMapper.selectByPrimaryKey(orders.getCommodityId());
        int num = commodity.getNumber() - orders.getNumber();
        int sallNum = commodity.getSellNum() + orders.getNumber();
        if (num >= 0){
            commodity.setNumber(num);
            commodity.setSellNum(sallNum);
            commodityMapper.updateByPrimaryKey(commodity);
            ordersMapper.insert(orders);
            Repay repay = new Repay();
            repay.setCustomerId(orders.getCustomerId());
            repay.setPaidStage(0);
            repay.setUnpadiStage(0);
            repay.setWillPayAmount(orders.getPayMoney()/orders.getStage());
            repay.setOrderId(1);
            repayMapper.insert(repay);
        }else {

        }
        return false;
    }
}
