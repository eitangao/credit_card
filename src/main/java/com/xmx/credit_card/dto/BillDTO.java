package com.xmx.credit_card.dto;

import java.math.BigDecimal;
import java.util.List;

public class BillDTO {
    //总账单额度
    private BigDecimal totalDebt;

    //每张银行卡对应的账单额度
    private List<CardDebt> cardDebt;

    public List<CardDebt> getCardDebt() {
        return cardDebt;
    }

    public void setCardDebt(List<CardDebt> cardDebt) {
        this.cardDebt = cardDebt;
    }

    public BigDecimal getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(BigDecimal totalDebt) {
        this.totalDebt = totalDebt;
    }
}
