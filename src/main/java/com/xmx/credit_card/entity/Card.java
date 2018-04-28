package com.xmx.credit_card.entity;

import com.xmx.credit_card.constant.CardType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Card {

    private String cardNumber;

    private BigDecimal cardAmount;

    private Integer cardPoint;

    private CardType cardType;

    private String inqpwd;

    private String acct;

    private LocalDateTime createTime;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(BigDecimal cardAmount) {
        this.cardAmount = cardAmount;
    }

    public Integer getCardPoint() {
        return cardPoint;
    }

    public void setCardPoint(Integer cardPoint) {
        this.cardPoint = cardPoint;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getInqpwd() {
        return inqpwd;
    }

    public void setInqpwd(String inqpwd) {
        this.inqpwd = inqpwd;
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
