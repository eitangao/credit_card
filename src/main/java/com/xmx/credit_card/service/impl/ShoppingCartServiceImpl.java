package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.command.ShoppingCommand;
import com.xmx.credit_card.dao.ShoppingCartMapper;
import com.xmx.credit_card.entity.ShoppingCart;
import com.xmx.credit_card.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void addShoppingList(ShoppingCommand shoppingCommand) {
        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.setProductId(shoppingCommand.getProductId());
        shoppingCart.setAcct(shoppingCommand.getAccount());
        shoppingCart.setCreateTime(LocalDateTime.now());
    }
}
