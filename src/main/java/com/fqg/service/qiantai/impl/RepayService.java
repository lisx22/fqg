package com.fqg.service.qiantai.impl;

import com.fqg.dao.RepayMapper;
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

    @Override
    public Integer selectWillRepayMoneyByCustomer(Integer customerId) {
        Integer repayMoney = 0;
        List<Integer> repayMoneyList = repayMapper.selectByCustomer(customerId);
        for (Integer integer : repayMoneyList) {
            repayMoney += integer;
        }
        return repayMoney;
    }
}
