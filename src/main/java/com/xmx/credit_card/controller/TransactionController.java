package com.xmx.credit_card.controller;

import com.xmx.credit_card.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
}
