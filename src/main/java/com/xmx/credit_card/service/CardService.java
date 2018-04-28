package com.xmx.credit_card.service;

import com.xmx.credit_card.command.CreateCardCommand;
import com.xmx.credit_card.constant.CardStatus;
import com.xmx.credit_card.constant.CardType;
import com.xmx.credit_card.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> getCardListByCondition(String account, CardType cardType, CardStatus cardStatus);
    boolean applyCard(CreateCardCommand command);
}
