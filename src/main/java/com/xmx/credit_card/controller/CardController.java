package com.xmx.credit_card.controller;

import com.xmx.credit_card.command.CreateCardCommand;
import com.xmx.credit_card.constant.CardStatus;
import com.xmx.credit_card.constant.CardType;
import com.xmx.credit_card.entity.Card;
import com.xmx.credit_card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/card")
public class CardController {
    @Autowired
    private CardService cardService;
    @RequestMapping(value = "/list")
    public List<Card> getCardListByCondition(@RequestParam(required = false)String account, @RequestParam(required = false)CardType cardType,
                                             @RequestParam(required = false)CardStatus status) {
        return cardService.getCardListByCondition(account, cardType,status);
    }
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public boolean applyCard(@RequestBody CreateCardCommand command){
        return cardService.applyCard(command);
    }

}
