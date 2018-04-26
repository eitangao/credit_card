package com.xmx.credit_card.service;

import com.xmx.credit_card.entity.User;

public interface UserService {

    boolean register(String account,String password);

    boolean login(String account,String password);

    void addUser(User user);

    Long getUserIdByAccount(String account);

    User getUserByAccount(String account);
}
