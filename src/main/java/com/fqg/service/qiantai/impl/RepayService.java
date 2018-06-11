package com.fqg.service.qiantai.impl;

import com.fqg.dao.RepayMapper;
import com.fqg.entity.Customer;
import com.fqg.entity.Orders;
import com.fqg.entity.Repay;
import com.fqg.service.qiantai.IRepayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 9:38
 */
@Service
public class RepayService implements IRepayService {

    @Resource
    private RepayMapper repayMapper;

    @Resource
    private OrderServiceQT orderService;

    @Resource
    private CustomerServiceQT customerService;

    @Override
    public Integer selectWillRepayMoneyByCustomer(Integer customerId) {
        Integer repayMoney = 0;
        List<Integer> repayMoneyList = repayMapper.selectWillPayAmountByCustomer(customerId);
        for (Integer integer : repayMoneyList) {
            repayMoney += integer;
        }
        return repayMoney;
    }

    @Override
    public void doWillRepay(Integer customerId) {
        Customer customer = customerService.selectById(customerId);
        List<Repay> repayList = repayMapper.selectByCustomer(customerId);
        for (Repay repay : repayList) {
            customer.setQuota(customer.getQuota() + repay.getWillPayAmount());
            if (repay.getUnpadiStage() == 1){
                repayMapper.deleteByPrimaryKey(repay.getRepayId());
                orderService.completeOrder(repay.getOrderId());
            }
            if (repay.getUnpadiStage() != 1){
                repay.setUnpadiStage(repay.getUnpadiStage()-1);
                repay.setPaidStage(repay.getPaidStage()+1);
                repay.setWillPayAmount(0);
                repayMapper.updateByPrimaryKeySelective(repay);
            }
        }
    }

    @Override
    public void reCalc() {
        List<Repay> repayList = repayMapper.selectAll();
        for (Repay repay : repayList) {
            Orders orders = orderService.selectById(repay.getOrderId());
            Integer willPayAmount = orders.getPayMoney()/orders.getStage();
            repay.setWillPayAmount(willPayAmount);
        }
    }

    @Override
    public void doOneOrderRepay(Integer repayId,Integer unPaidMoney) {
        Repay repay = repayMapper.selectByPrimaryKey(repayId);
        Customer customer = customerService.selectById(repay.getCustomerId());
        customer.setQuota(customer.getQuota() + unPaidMoney);
        orderService.completeOrder(repay.getOrderId());
        repayMapper.deleteByPrimaryKey(repayId);
    }
}
