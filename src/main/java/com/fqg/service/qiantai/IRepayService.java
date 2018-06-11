package com.fqg.service.qiantai;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/9
 * @Time 11:09
 */
public interface IRepayService {
    Integer selectWillRepayMoneyByCustomer(Integer customerId);

    void doWillRepay(Integer customerId);

    void reCalc();

    void doOneOrderRepay(Integer repayId,Integer unPaidMoney);
}
