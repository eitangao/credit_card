package com.xmx.credit_card.controller;

import com.xmx.credit_card.command.BuyGoodsCommand;
import com.xmx.credit_card.constant.ApplicaplePeople;
import com.xmx.credit_card.constant.ProductType;
import com.xmx.credit_card.entity.Goods;
import com.xmx.credit_card.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Goods> getGoodsListByCondition(@RequestParam(required = false) ProductType productType , @RequestParam(required = false) ApplicaplePeople applicaplePeople,
                                               @RequestParam(required = false) String lowPrice,@RequestParam(required = false) String highPrice,@RequestParam(required = false) String orderBy,
                                               @RequestParam(required = false)String order){
        return goodsService.getGoodsByCondition(productType,applicaplePeople,lowPrice,highPrice,orderBy,order);
    }
    @RequestMapping(value = "/buy")
    public void buyGoods(@RequestBody BuyGoodsCommand buyGoodsCommand){
        goodsService.buyGoods(buyGoodsCommand);
    }

    @RequestMapping(value = "/recommend")
    public List<Goods> getHotGoods(@RequestParam String account){
        return goodsService.getHotGoods(account);
    }
}
