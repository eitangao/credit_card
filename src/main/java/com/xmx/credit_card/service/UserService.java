package com.xmx.credit_card.service;

import com.xmx.credit_card.command.UpdateUserCommand;
import com.xmx.credit_card.dto.BillDTO;
import com.xmx.credit_card.dto.PointDTO;
import com.xmx.credit_card.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    boolean register(String account,String password);

    boolean login(String account,String password);

    BigDecimal getAmountByAccount(String account);

    void updateAmount(String account,BigDecimal amount);

    void updatePoint(String account,Integer point);

    void updateUserInfo(UpdateUserCommand updateUserCommand);

    BillDTO getBillByAccount(String account);

    PointDTO getPointByAccount(String account);

    List<User> getUserList();

    void addUser(User user);

    Long getUserIdByAccount(String account);

    User getUserByAccount(String account);
}
