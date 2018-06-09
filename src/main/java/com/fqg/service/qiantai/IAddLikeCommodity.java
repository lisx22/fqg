package com.fqg.service.qiantai;

import com.fqg.entity.Customer;
import com.fqg.entity.LikeCommodity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 加入收藏夹
 * @author zhj
 * @time 2016/6/9
 */
@Service
public interface IAddLikeCommodity {
    List<LikeCommodity > addLikeCommodity(Customer customer, int commodityId);
}
