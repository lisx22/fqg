package com.fqg.service.qiantai.impl;

import com.fqg.dao.OrderVOMapper;
import com.fqg.entity.OrderVO;
import com.fqg.service.qiantai.IOrderVOService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/11
 * @Time 9:17
 */
@Service
public class OrderVOService implements IOrderVOService {

    @Resource
    private OrderVOMapper orderVOMapper;

    @Override
    public List<OrderVO> selectByCustomer(Integer customerId) {
        List<OrderVO> orderVOList = orderVOMapper.selectByCustomer(customerId);
        return orderVOList;
    }

}
