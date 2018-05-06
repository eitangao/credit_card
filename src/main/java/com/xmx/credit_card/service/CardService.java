package com.xmx.credit_card.service;

import com.xmx.credit_card.command.CreateCardCommand;
import com.xmx.credit_card.constant.CardStatus;
import com.xmx.credit_card.constant.CardType;
import com.xmx.credit_card.entity.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {

    List<Card> getCardListByCondition(String account, CardType cardType, CardStatus cardStatus);

    BigDecimal getAmountByCardNumber(String cardNumber);

    Card getCardByCardNumber(String cardNumber);

    void updateCardByCardNumber(String cardNumber, BigDecimal amount,Integer point);

    void repayment(String cardNumber,BigDecimal amount);

    boolean applyCard(CreateCardCommand command);

    void approveCardApply(String cardNumber,boolean approve);


    void deleteCard(String cardNumber);

    List<Integer> countCardGroupByCardType();
}
