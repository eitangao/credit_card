package com.xmx.credit_card.controller;

import com.xmx.credit_card.command.ShoppingCommand;
import com.xmx.credit_card.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shopping_cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/add")
    public void addShoppingList(@RequestBody ShoppingCommand shoppingCommand){
        shoppingCartService.addShoppingList(shoppingCommand);
    }
}
