package com.xmx.credit_card.command;

import com.xmx.credit_card.constant.CardType;

public class CreateCardCommand {

    private CardType cardType;

    private String account;

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
