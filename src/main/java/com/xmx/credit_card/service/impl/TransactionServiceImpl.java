package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.dao.TransactionMapper;
import com.xmx.credit_card.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;
}
