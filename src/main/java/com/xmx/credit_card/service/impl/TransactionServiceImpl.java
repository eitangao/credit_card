package com.xmx.credit_card.service.impl;

import com.xmx.credit_card.dao.TransactionMapper;
import com.xmx.credit_card.entity.Transaction;
import com.xmx.credit_card.entity.TransactionExample;
import com.xmx.credit_card.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<Transaction> getTransactionListByAccount(String account) {
        TransactionExample example=new TransactionExample();
        TransactionExample.Criteria criteria=example.createCriteria();
        criteria.andAcctEqualTo(account);
        example.setOrderByClause("create_time desc");
        return transactionMapper.selectByExample(example);
    }

    @Override
    public void createTransaction(Transaction transaction) {
        transactionMapper.insert(transaction);
    }
}
