package com.xmx.credit_card.service;

import com.xmx.credit_card.command.ShoppingCommand;

public interface ShoppingCartService {
    void addShoppingList(ShoppingCommand shoppingCommand);
}
