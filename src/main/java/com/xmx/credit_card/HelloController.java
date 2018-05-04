package com.xmx.credit_card;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/applycard")
    public String applycard(){
        return "applycard";
    }
    @RequestMapping(value = "/card")
    public String card(){
        return "card";
    }
    @RequestMapping(value = "/event")
    public String event(){
        return "event";
    }
    @RequestMapping(value = "/eventline")
    public String eventline(){
        return "eventline";
    }
    @RequestMapping(value = "/gooddetail")
    public String gooddetail(){
        return "gooddetail";
    }
    @RequestMapping(value = "/Goods")
    public String Goods(){
        return "Goods";
    }
    @RequestMapping(value = "/point")
    public String point(){
        return "point";
    }
    @RequestMapping(value = "/pointrecord")
    public String pointrecord(){
        return "pointrecord";
    }
    @RequestMapping(value = "/progress")
    public String progress(){
        return "progress";
    }
    @RequestMapping(value = "/regist")
    public String regist(){
        return "regist";
    }
    @RequestMapping(value = "/repayment")
    public String repayment(){
        return "repayment";
    }
    @RequestMapping(value = "/shoppingcart")
    public String shoppingcart(){
        return "shoppingcart";
    }

}
