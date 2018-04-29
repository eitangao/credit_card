package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.command.BuyGoodsCommand;
import com.xmx.credit_card.constant.ApplicaplePeople;
import com.xmx.credit_card.constant.ProductType;
import com.xmx.credit_card.dao.GoodsMapper;
import com.xmx.credit_card.entity.Card;
import com.xmx.credit_card.entity.Goods;
import com.xmx.credit_card.entity.Transaction;
import com.xmx.credit_card.entity.User;
import com.xmx.credit_card.service.CardService;
import com.xmx.credit_card.service.GoodsService;
import com.xmx.credit_card.service.TransactionService;
import com.xmx.credit_card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    @Autowired
    private TransactionService transactionService;

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
    public Goods findGoodsById(Long id) {
        return goodsMapper.getGoodsById(id);
    }

    @Override
    public void updateGoodsCount(Long id) {
        goodsMapper.updateGooodsCount(id);
    }

    @Override
    @Transactional
    public void buyGoods(BuyGoodsCommand buyGoodsCommand) {
        if(buyGoodsCommand.getAccount()==null||buyGoodsCommand.getCardNumber()==null||buyGoodsCommand.getProductId()==null)
            throw new RuntimeException("Shopping information is not enough!");
        Goods goods=goodsMapper.getGoodsById(buyGoodsCommand.getProductId());
        if(goods==null)
            throw new RuntimeException("Goods does not exist!");
        Card card=cardService.getCardByCardNumber(buyGoodsCommand.getCardNumber());
        if(card==null)
            throw new RuntimeException("Card does not exist!");
        User user=userService.getUserByAccount(buyGoodsCommand.getAccount());
        if(user==null)
            throw new RuntimeException("User does not exist!");
        //查询可用额度
        BigDecimal userAmount=user.getAmount();
        BigDecimal cardAmount=card.getCardAmount();
        if(goods.getPrice().compareTo(userAmount)==1||goods.getPrice().compareTo(cardAmount)==1)
            throw new RuntimeException("Not enough amount!");
        //更新额度和积分
        userService.updateAmount(buyGoodsCommand.getAccount(),userAmount.subtract(goods.getPrice()));
        userService.updatePoint(buyGoodsCommand.getAccount(),user.getPoint()+goods.getPoint());
        cardService.updateCardByCardNumber(buyGoodsCommand.getCardNumber(),cardAmount.subtract(goods.getPrice()),card.getCardPoint()+goods.getPoint());
        //货物销量更新
        updateGoodsCount(buyGoodsCommand.getProductId());
        //产生交易记录
        Transaction transaction=new Transaction();
        transaction.setAcct(buyGoodsCommand.getAccount());
        transaction.setAmount(goods.getPrice());
        transaction.setCardNumber(buyGoodsCommand.getCardNumber());
        transaction.setProductId(buyGoodsCommand.getProductId());
        transaction.setPoint(goods.getPoint());
        transaction.setCreateTime(LocalDateTime.now());
        transactionService.createTransaction(transaction);
    }
}
