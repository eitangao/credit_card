package com.xmx.credit_card.dto;

import com.xmx.credit_card.constant.CardType;

import java.math.BigDecimal;

public class CardDebt {

    private String cardNumber;

    private CardType cardType;

    private BigDecimal cardDebt;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public BigDecimal getCardDebt() {
        return cardDebt;
    }

    public void setCardDebt(BigDecimal cardDebt) {
        this.cardDebt = cardDebt;
    }
}
