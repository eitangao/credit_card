package com.xmx.credit_card.controller;
import com.xmx.credit_card.command.UpdateUserCommand;
import com.xmx.credit_card.dto.BillDTO;

import com.xmx.credit_card.dto.PointDTO;
import com.xmx.credit_card.entity.User;
import com.xmx.credit_card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController implements Serializable {
    @Autowired
    private UserService userService;


    @RequestMapping(value="/register/{account}/{password}")
    public boolean register(@PathVariable(value = "account") String account,
                                               @PathVariable(value = "password") String password){
        return userService.register(account,password);
    }
    @RequestMapping(value="/login/{account}/{password}")
    public boolean login(@PathVariable(value = "account") String account,
                            @PathVariable(value = "password") String password){
        return userService.login(account,password);
    }
    //更新用户基本信息
    @RequestMapping(value = "/update")
    public void updateUserInfo(@RequestBody UpdateUserCommand updateUserCommand){
        userService.updateUserInfo(updateUserCommand);
    }
    @RequestMapping(value = "/bill/{account}")
    public BillDTO getBillByAccount(@PathVariable(value = "account")String account){
        return userService.getBillByAccount(account);
    }
    @RequestMapping(value = "/point/{account}")
    public PointDTO getPointByAccount(@PathVariable(value = "account")String account){
        return userService.getPointByAccount(account);
    }
    @RequestMapping(value = "/list")
    public List<User> getUserList(){
        return userService.getUserList();
    }



}
