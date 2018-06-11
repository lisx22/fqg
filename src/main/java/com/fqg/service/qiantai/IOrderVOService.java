package com.fqg.service.qiantai;

import com.fqg.entity.OrderVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 9:07
 */
public interface IOrderVOService {
    List<OrderVO> selectByCustomer(Integer customerId);
}
