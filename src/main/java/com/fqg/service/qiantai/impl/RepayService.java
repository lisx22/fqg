package com.fqg.service.qiantai.impl;

import com.fqg.dao.OverRepayMapper;
import com.fqg.dao.OverTimeInterestMapper;
import com.fqg.dao.RepayMapper;
import com.fqg.entity.Customer;
import com.fqg.entity.Orders;
import com.fqg.entity.OverRepay;
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
    private OverRepayMapper overRepayMapper;

    @Resource
    private RepayMapper repayMapper;

    @Resource
    private OverTimeInterestMapper overTimeInterestMapper;

    @Resource
    private OrderServiceQT orderService;

    @Resource
    private CustomerServiceQT customerService;

    @Override
    public Double selectThisMonthRepay(Integer customerId) {
        Double repayMoney = 0.0;
        List<Integer> repayMoneyList = repayMapper.selectWillPayAmountByCustomer(customerId);
        for (Integer integer : repayMoneyList) {
            repayMoney += integer;
        }
        return repayMoney;
    }

    @Override
    public Double selectOverRepay(Integer customerId) {
        Double repayMoney = 0.0;
        OverRepay overRepay = overRepayMapper.selectByCustomer(customerId);
        Double overTimeInterest = overTimeInterestMapper.selectOverTimeInterest();
        if (overRepay != null){
            repayMoney = overRepay.getOverAmount() * (1+overRepay.getOverDay() * overTimeInterest);
        }
        return repayMoney;
    }

    @Override
    public void doThisMonthRepay(Integer customerId) {
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
    public void reCalcOverRepay() {
        Double overTimeInterest = overTimeInterestMapper.selectOverTimeInterest();
        List<Integer> customerIdList = overRepayMapper.selectCustomerId();
        List<OverRepay> overRepayList = overRepayMapper.selectAll();
        for (OverRepay overRepay : overRepayList) {
            overRepay.setOverAmount(overRepay.getOverAmount() * (1 + overRepay.getOverDay() * overTimeInterest));
            overRepay.setOverDay(0);
            overRepayMapper.updateByPrimaryKeySelective(overRepay);
        }
        List<Repay> repayList = repayMapper.selectAll();
        for (Repay repay : repayList) {
            if (repay.getWillPayAmount() != 0) {
                Integer customerId = repay.getCustomerId();
                if (customerIdList.contains(customerId)) {
                    OverRepay overRepay = overRepayMapper.selectByCustomer(customerId);
                    overRepay.setOverAmount(overRepay.getOverAmount() + repay.getWillPayAmount());
                    overRepayMapper.updateByPrimaryKeySelective(overRepay);
                }
                if (!customerIdList.contains(customerId)) {
                    OverRepay overRepay = new OverRepay();
                    overRepay.setCustomerId(customerId);
                    overRepay.setOverAmount(repay.getWillPayAmount().doubleValue());
                    overRepay.setOverDay(0);
                    overRepayMapper.insertSelective(overRepay);
                }
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
    }

    @Override
    public void doOverRepay(Integer customerId) {
        overRepayMapper.deleteByCustomer(customerId);
    }

    @Override
    public void reCalcThisMonthRepay() {
        List<Repay> repayList = repayMapper.selectAll();
        for (Repay repay : repayList) {
            Orders orders = orderService.selectById(repay.getOrderId());
            repay.setWillPayAmount(orders.getAmount());
            repayMapper.updateByPrimaryKeySelective(repay);
        }
    }

    @Override
    public void addOverRepayDay() {
        List<OverRepay> overRepayList = overRepayMapper.selectAll();
        for (OverRepay overRepay : overRepayList) {
            overRepay.setOverDay(overRepay.getOverDay()+1);
            overRepayMapper.updateByPrimaryKeySelective(overRepay);
        }
    }
}
