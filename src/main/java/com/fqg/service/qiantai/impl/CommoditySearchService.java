package com.fqg.service.qiantai.impl;

import com.fqg.dao.CommoditySmallVOMapper;
import com.fqg.entity.CommoditySelect;
import com.fqg.entity.CommoditySmallVO;
import com.fqg.entity.PageInfo;
import com.fqg.service.qiantai.ICommoditySearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author 陈锴鹏
 * @Date 2018/6/6
 * @Time 16:53
 */
@Service
public class CommoditySearchService implements ICommoditySearchService {

    @Resource
    private CommoditySmallVOMapper commoditySmallVOMapper;

    @Override
    public PageInfo<CommoditySmallVO> selectByCommoditySelect(CommoditySelect commoditySelect) {
        /*String commodityKey = String.valueOf(commoditySelect.hashCode());
        String countKey = String.valueOf(commoditySelect.hashCode()) + "count";
        int total=commodityMapper.countByTypeOne(typeOneId);
        int pageCount=total% PageInfo.PAGE_SIZE==0?
                total/PageInfo.PAGE_SIZE:total/PageInfo.PAGE_SIZE+1;
        List<Commodity> commodityList=commodityMapper.selectByTypeOnePaging((pageNo-1)*PageInfo.PAGE_SIZE,
                PageInfo.PAGE_SIZE,typeOneId);
        PageInfo<Commodity> page=new PageInfo<>();
        page.setData(commodityList);
        page.setPageCount(pageCount);
        page.setPageNo(pageNo);
        return page;*/
        return null;
    }
}
