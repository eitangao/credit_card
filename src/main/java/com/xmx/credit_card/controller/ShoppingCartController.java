package com.xmx.credit_card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shopping_cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartController shoppingCartController;
}
