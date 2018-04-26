package com.xmx.credit_card;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }
}
