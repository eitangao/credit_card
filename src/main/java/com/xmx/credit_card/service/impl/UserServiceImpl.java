package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.dao.UserMapper;
import com.xmx.credit_card.entity.User;
import com.xmx.credit_card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(String account, String password) {
        if(userMapper.getUserIdByAccount(account)!=null)
            throw new RuntimeException("Account already exists");
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setCreateTime(LocalDateTime.now());
        userMapper.addUser(user);
        return true;
    }

    @Override
    public boolean login(String account, String password) {
        if(userMapper.getUserByAccount(account).getPassword().equals(password))
            return true;
        else
            return false;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public Long getUserIdByAccount(String account) {
        return userMapper.getUserIdByAccount(account);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }
}
