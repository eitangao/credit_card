package com.xmx.credit_card.controller;
import com.xmx.credit_card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/user")
public class UserController implements Serializable {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/test")
    public String test(){
        return "testController";
    }
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
}
