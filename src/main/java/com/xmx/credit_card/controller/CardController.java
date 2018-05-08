package com.xmx.credit_card.controller;

import com.xmx.credit_card.command.CreateCardCommand;
import com.xmx.credit_card.constant.CardStatus;
import com.xmx.credit_card.constant.CardType;
import com.xmx.credit_card.entity.Card;
import com.xmx.credit_card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    @RequestMapping(value = "/approve")
    public boolean approveCardApply(@RequestParam String cardNumber,@RequestParam Boolean approve){
        cardService.approveCardApply(cardNumber,approve);
        return true;
    }
    @RequestMapping(value = "/repayment")
    public void repayment(@RequestParam(value = "cardNumber") String cardNumber, @RequestParam(value = "amount")BigDecimal amount){
        cardService.repayment(cardNumber,amount);
    }

    @RequestMapping(value = "/countcard")
    public List<Integer> countCardGroupByCardType(){
        return cardService.countCardGroupByCardType();
    }

    @RequestMapping(value = "/cardstatus")
    public Card getCardByCardNumber(@RequestParam(value = "cardNumber") String cardNumber){
        return cardService.getCardByCardNumber(cardNumber);
    }

    @RequestMapping(value = "/opencarduser")
    public List<Integer> countCardGroupByAcct(){
        return cardService.countCardGroupByAcct();
    }

    @RequestMapping(value = "/sumpoint")
    public List<Integer> sumCardPointByCard(@RequestParam(value = "account") String account){
        return cardService.sumCardPointByCard(account);
    }

    @RequestMapping(value = "/repay")
    public void eventRepay(@RequestParam(value = "cardNumber") String cardNumber,@RequestParam(value = "point") Integer point,@RequestParam(value = "amount") BigDecimal amount){
        cardService.eventRepay(cardNumber,point,amount);
    }

    @RequestMapping(value = "/play")
    public void play(@RequestParam(value = "cardNumber") String cardNumber,@RequestParam(value = "point") Integer point){
        cardService.play(cardNumber,point);
    }

}
