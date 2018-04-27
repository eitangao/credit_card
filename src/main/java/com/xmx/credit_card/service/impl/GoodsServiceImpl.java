package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.constant.ApplicaplePeople;
import com.xmx.credit_card.constant.ProductType;
import com.xmx.credit_card.dao.GoodsMapper;
import com.xmx.credit_card.entity.Goods;
import com.xmx.credit_card.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsByCondition(ProductType productType, ApplicaplePeople applicaplePeople, String lowPrice, String highPrice, String orderBy, String order) {
        Map condition=new HashMap();
        condition.put("productType",productType);
        condition.put("applicaplePeople",applicaplePeople);
        condition.put("lowPrice",lowPrice);
        condition.put("highPrice",highPrice);
        condition.put("orderBy",orderBy);
        condition.put("order",order);
        return goodsMapper.getGoodsByCondition(condition);
    }

    @Override
    public Goods findGoodsById() {
        return goodsMapper.list();
    }
}
