package com.xmx.credit_card.service;

import com.xmx.credit_card.entity.Transaction;

import java.util.List;

public interface TransactionService {

    void createTransaction(Transaction transaction);

    List<Transaction> getTransactionListByAccount(String account);
}
