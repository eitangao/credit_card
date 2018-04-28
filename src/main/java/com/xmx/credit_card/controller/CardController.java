package com.xmx.credit_card.controller;

import com.xmx.credit_card.constant.CardType;
import com.xmx.credit_card.entity.Card;
import com.xmx.credit_card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/card")
public class CardController {
    @Autowired
    private CardService cardService;
    @RequestMapping(value = "/list")
    public List<Card> getCardListByCondition(@RequestParam(required = false)String account, @RequestParam(required = false)CardType cardType){
        return cardService.getCardListByCondition(account,cardType);
        }

}
