package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.command.BuyGoodsCommand;
import com.xmx.credit_card.constant.ApplicaplePeople;
import com.xmx.credit_card.constant.ProductType;
import com.xmx.credit_card.dao.GoodsMapper;
import com.xmx.credit_card.dto.HotProduct;
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
import org.springframework.util.CollectionUtils;
import sun.awt.datatransfer.DataTransferer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

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
    public void insert(Goods goods) {
        goodsMapper.insert(goods);
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
        transaction.setProduct(buyGoodsCommand.getProductId());
        transaction.setPoint(goods.getPoint());
        transaction.setCreateTime(LocalDateTime.now());
        transactionService.createTransaction(transaction);
    }

    @Override
    public List<Goods> getHotGoods(String account) {
        List<Goods> mostSellingGoods=getGoodsByCondition(null,null,null,null,"count","desc");
        List<HotProduct> hotProductList=new ArrayList<>();
        //对销量计算推荐基数
        int i=20;
        if(CollectionUtils.isEmpty(mostSellingGoods))
            return new ArrayList<>();
        for (Goods mostSellingGood : mostSellingGoods) {
            HotProduct hotProduct=new HotProduct();
            hotProduct.setProductId(mostSellingGood.getId());
            hotProduct.setCreateTime(mostSellingGood.getCreateTime());
            hotProduct.setPrice(mostSellingGood.getPrice());
            hotProduct.setProductType(mostSellingGood.getProductType());
            if(i>0){
                hotProduct.setHotPoint(i--);
            }
            else{
                hotProduct.setHotPoint(1);
            }
            hotProductList.add(hotProduct);
        }
        //对上架时间计算推荐基数
        hotProductList.sort((HotProduct h1,HotProduct h2)->h2.getCreateTime().compareTo(h1.getCreateTime()));
        int j=15;
        for (HotProduct hotProduct : hotProductList) {
            if(j>5)
                hotProduct.setHotPoint(hotProduct.getHotPoint()+j--);
            else
                hotProduct.setHotPoint(hotProduct.getHotPoint()+5);
        }
        //如果用户购买不超过5件，只按照商品销量和上架时间推荐
        List<Transaction> transactionList=transactionService.getTransactionListByAccount(account);
        if(transactionList.size()<6){
            List<Goods> hotGoods=new ArrayList<>();
            if(hotProductList.size()<13){
                hotProductList.forEach((h)->hotGoods.add(goodsMapper.getGoodsById(h.getProductId())));
            }
            else{
                for(int m=0;m<12;m++){
                    hotGoods.add(goodsMapper.getGoodsById(hotProductList.get(m).getProductId()));
                }
            }
            return hotGoods;
        }
        //基于用户最多购买种类计算推荐系数
        Map<ProductType,Integer> typeHot=new HashMap<>();
        for (Transaction transaction : transactionList) {
            ProductType productType=goodsMapper.getGoodsById(transaction.getProduct()).getProductType();
            if(typeHot.containsKey(productType))
                typeHot.put(productType,typeHot.get(productType)+1);
            else
                typeHot.put(productType,1);
        }
        List<Map.Entry<ProductType,Integer>> sortedTypeHot=new ArrayList<>(typeHot.entrySet());
        sortedTypeHot.sort((Map.Entry<ProductType,Integer> o1,Map.Entry<ProductType,Integer> o2)->o2.getValue().compareTo(o1.getValue()));
        Map<ProductType,Double> typeCoefficient=new HashMap<>();//按购买量最多种类推荐系数
        Double biggestCoefficient=0.5;
        for (Map.Entry<ProductType, Integer> entry : sortedTypeHot) {
            if(biggestCoefficient>0.0)
                typeCoefficient.put(entry.getKey(),biggestCoefficient);
            biggestCoefficient-=0.1;
        }
        //基于用户购买力计算推荐系数
        int number=0;
        BigDecimal totalAmount=new BigDecimal(0);
        for (Transaction transaction : transactionList) {
            Goods goods=goodsMapper.getGoodsById(transaction.getProduct());
            totalAmount=totalAmount.add(goods.getPrice());
            number++;
        }
        Double avgAmount=totalAmount.doubleValue()/number;
        Double lowAmount=avgAmount*0.5;
        Double highAmount=avgAmount*1.5;
        for (HotProduct hotProduct : hotProductList) {
            Double hotType=typeCoefficient.get(hotProduct.getProductType());
            if(hotType!=null)
                hotProduct.setHotType(hotType);
            else
                hotProduct.setHotType(0.1);
            Double price=hotProduct.getPrice().doubleValue();
            if(price>highAmount)
                if(price<highAmount*1.9){
                    Double highRate=(price-highAmount)/highAmount;
                    hotProduct.setPurchasingPower(1-new BigDecimal(highRate).setScale(1,BigDecimal.ROUND_UP).doubleValue());
                }
                else
                    hotProduct.setPurchasingPower(0.1);
            else if(price<lowAmount){
                if(price>lowAmount*0.1){
                    Double lowRate=lowAmount-price/lowAmount;
                    hotProduct.setPurchasingPower(1-new BigDecimal(lowRate).setScale(1,BigDecimal.ROUND_UP).doubleValue());
                }
                else
                    hotProduct.setPurchasingPower(0.1);
            }
            else
                hotProduct.setPurchasingPower(1.0);
            hotProduct.setFinalPoint(hotProduct.getHotPoint()*(1+hotProduct.getHotType())*hotProduct.getPurchasingPower());
        }
        hotProductList.sort((HotProduct h1,HotProduct h2)->h2.getFinalPoint().compareTo(h1.getFinalPoint()));
        List<Goods> hotGoods=new ArrayList<>();
        if(hotProductList.size()<13){
            hotProductList.forEach((h)->hotGoods.add(goodsMapper.getGoodsById(h.getProductId())));
        }
        else{
            for(int m=0;m<12;m++){
                hotGoods.add(goodsMapper.getGoodsById(hotProductList.get(m).getProductId()));
            }
        }
        return hotGoods;
    }
}
