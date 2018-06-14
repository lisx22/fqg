package com.fqg.service.qiantai;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/9
 * @Time 11:09
 */
public interface IRepayService {

    Double selectThisMonthRepay(Integer customerId);

    Double selectOverRepay(Integer customerId);

    void doThisMonthRepay(Integer customerId);

    void doOverRepay(Integer customerId);

    void reCalcThisMonthRepay();

    void addOverRepayDay();

    void reCalcOverRepay();
}
