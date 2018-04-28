package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.command.BuyGoodsCommand;
import com.xmx.credit_card.constant.ApplicaplePeople;
import com.xmx.credit_card.constant.ProductType;
import com.xmx.credit_card.dao.GoodsMapper;
import com.xmx.credit_card.entity.Goods;
import com.xmx.credit_card.service.CardService;
import com.xmx.credit_card.service.GoodsService;
import com.xmx.credit_card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;

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

    @Override
    @Transactional
    public void buyGoods(BuyGoodsCommand buyGoodsCommand) {
        BigDecimal userAmount=userService.getAmountByAccount(buyGoodsCommand.getAccount());
        BigDecimal cardAmount=cardService.getAmountByCardNumber(buyGoodsCommand.getCardNumber());
        Goods goods=goodsMapper.getGoodsById(buyGoodsCommand.getProductId());
        if(goods.getPrice().compareTo(userAmount)==1||goods.getPrice().compareTo(cardAmount)==1)
            throw new RuntimeException("Not enough amount!");
        userService.updateAmount(buyGoodsCommand.getAccount(),userAmount.subtract(goods.getPrice()));

    }
}
