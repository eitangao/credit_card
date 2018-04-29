package com.xmx.credit_card.service;

import com.xmx.credit_card.command.ShoppingCommand;

import java.util.List;

public interface ShoppingCartService {

    void addShoppingList(ShoppingCommand shoppingCommand);

    void deleteSingleShoppingListById(Long id);

    void clearShoppingListByAccount(String account);

    void buyInShoppingCard(List<Long> idList, String cardNumber);
}
