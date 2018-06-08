package com.fqg.service.qiantai;

import com.fqg.entity.CommoditySelect;
import com.fqg.entity.CommoditySmallVO;
import com.fqg.entity.PageInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * 商品筛选，分页
 * @author 陈锴鹏
 * @Date 2018/6/6
 * @Time 16:53
 */
public interface ICommoditySearchService {

    PageInfo<CommoditySmallVO> selectByCommoditySelect(CommoditySelect commoditySelect , Integer pageNo);

    List<CommoditySmallVO> selectOrderByCreateTime();

}
