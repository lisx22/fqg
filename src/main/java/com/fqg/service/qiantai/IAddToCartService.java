package com.fqg.service.qiantai;

import com.fqg.entity.Cart;
import com.fqg.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 添加商品进购物车接口
 * @author zhj
 * @time 2018/6/9
 */
@Service
public interface IAddToCartService {
    List<Cart> addToCart(Customer customer,String str);
}
