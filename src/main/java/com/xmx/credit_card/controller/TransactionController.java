package com.xmx.credit_card.controller;

import com.xmx.credit_card.entity.Transaction;
import com.xmx.credit_card.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @RequestMapping(value = "/list")
    public List<Transaction> getTransactionListByAccount(@RequestParam String account){
        return transactionService.getTransactionListByAccount(account);
    }
}
