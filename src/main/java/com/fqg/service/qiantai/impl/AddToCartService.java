package com.fqg.service.qiantai.impl;

import com.fqg.dao.CartMapper;
import com.fqg.entity.Cart;
import com.fqg.entity.Customer;
import com.fqg.service.qiantai.IAddToCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 添加商品至购物车
 * @author zhj
 * @time 2018/6/9
 */
@Service
@Transactional
public class AddToCartService implements IAddToCartService{

    private Cart cart = new Cart();
    @Resource
    private CartMapper cartMapper;
    @Override
    public List<Cart> addToCart(Customer customer, String str) {
        /*PageHelper.startPage(1,5);
        List<String> list = new ArrayList();
        PageInfo<String> pageInfo = new PageInfo(list);
        return pageInfo;*/
        cart.setCommodityInfo(str);
        cart.setCustomerId(customer.getCustomerId());
        cart.setCommodityId(Integer.parseInt(str.subSequence(0, 1).toString()));
        cartMapper.insertSelective(cart);
        List<Cart> carts = cartMapper.selectByCustomerId(customer.getCustomerId());
        return carts;
    }
}
