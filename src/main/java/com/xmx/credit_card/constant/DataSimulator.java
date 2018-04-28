package com.xmx.credit_card.constant;

import java.util.Random;

public class DataSimulator {

    public static String randomCardNumber(String cardType){
        StringBuilder sb=new StringBuilder();
        switch (cardType){
            case "BABY_GROWUP":
                sb.append(622230);
                break;
            case "COMMERICAL":
                sb.append(370246);
                break;
            case "GLOBAL_TRAVEL":
                sb.append(622599);
                break;
            case "CHANGLONG":
                sb.append(625860);
                break;
                default:
                    sb.append(666666);
        }
        for(int i=0;i<13;i++){
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }
}
