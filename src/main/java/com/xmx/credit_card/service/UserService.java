package com.xmx.credit_card.service;

import com.xmx.credit_card.entity.User;

import java.math.BigDecimal;

public interface UserService {

    boolean register(String account,String password);

    boolean login(String account,String password);

    BigDecimal getAmountByAccount(String account);

    void updateAmount(String account,BigDecimal amount);

    void addUser(User user);

    Long getUserIdByAccount(String account);

    User getUserByAccount(String account);
}
