package com.xmx.credit_card.service;

import com.xmx.credit_card.constant.CardType;
import com.xmx.credit_card.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> getCardListByCondition(String account, CardType cardType);
}
