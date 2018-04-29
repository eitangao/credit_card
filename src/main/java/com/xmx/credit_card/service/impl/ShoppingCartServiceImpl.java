package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.command.BuyGoodsCommand;
import com.xmx.credit_card.command.ShoppingCommand;
import com.xmx.credit_card.dao.ShoppingCartMapper;
import com.xmx.credit_card.entity.ShoppingCart;
import com.xmx.credit_card.entity.ShoppingCartExample;
import com.xmx.credit_card.service.CardService;
import com.xmx.credit_card.service.GoodsService;
import com.xmx.credit_card.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CardService cardService;

    @Override
    public void addShoppingList(ShoppingCommand shoppingCommand) {
        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.setProductId(shoppingCommand.getProductId());
        shoppingCart.setAcct(shoppingCommand.getAccount());
        shoppingCart.setCreateTime(LocalDateTime.now());
        shoppingCartMapper.insert(shoppingCart);
    }

    @Override
    public void deleteSingleShoppingListById(Long id) {
        shoppingCartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void clearShoppingListByAccount(String account) {
        ShoppingCartExample example=new ShoppingCartExample();
        ShoppingCartExample.Criteria criteria=example.createCriteria();
        criteria.andAcctEqualTo(account);
        shoppingCartMapper.deleteByExample(example);
    }

    @Override
    public void buyInShoppingCard(List<Long> idList, String cardNumber) {
        String account=cardService.getCardByCardNumber(cardNumber).getAcct();
        for (Long id : idList) {
            BuyGoodsCommand command=new BuyGoodsCommand();
            command.setAccount(account);
            command.setCardNumber(cardNumber);
            command.setProductId(id);
            goodsService.buyGoods(command);
            deleteSingleShoppingListById(id);
        }

    }
}
