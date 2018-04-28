package com.xmx.credit_card.constant;

public enum CardStatus {
    //刚申请时
    INACTIVE,
    /**
     * 申请通过时
     */
    ACTIVE,
    /**
     * 申请拒绝
     */
    REJECTED,
    /**
     * 卡被注销
     */
    DELETE
}
