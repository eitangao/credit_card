package com.xmx.credit_card.model;

import java.math.BigDecimal;
import java.util.Date;

public class Card {
    private String cardNumber;

    private BigDecimal cardAmount;

    private Integer cardPoint;

    private String cardType;

    private String inqpwd;

    private String acct;

    private Date createTime;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getInqpwd() {
        return inqpwd;
    }

    public void setInqpwd(String inqpwd) {
        this.inqpwd = inqpwd == null ? null : inqpwd.trim();
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct == null ? null : acct.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}