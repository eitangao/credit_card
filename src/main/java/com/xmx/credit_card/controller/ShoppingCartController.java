package com.xmx.credit_card.controller;

import com.xmx.credit_card.command.ShoppingCommand;
import com.xmx.credit_card.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shopping_cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/add")
    public void addShoppingList(@RequestBody ShoppingCommand shoppingCommand){
        shoppingCartService.addShoppingList(shoppingCommand);
    }
    @RequestMapping(value = "delete")
    public void deleteSingleShoppingListById(Long id){
        shoppingCartService.deleteSingleShoppingListById(id);
    }
    @RequestMapping(value = "clear/{account}")
    public void clearShoppingCartByAccount(@PathVariable(value = "account")String account){
        shoppingCartService.clearShoppingListByAccount(account);
    }
    @RequestMapping(value = "/buy")
    public void buyInShoppingCart(@RequestParam List<Long> idList, @RequestParam String cardNumber){
        shoppingCartService.buyInShoppingCard(idList,cardNumber);
    }
}
