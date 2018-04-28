package com.xmx.credit_card.dao;

import java.util.List;

import com.xmx.credit_card.entity.Transaction;
import com.xmx.credit_card.entity.TransactionExample;
import org.apache.ibatis.annotations.Param;

public interface TransactionMapper {
    int countByExample(TransactionExample example);

    int deleteByExample(TransactionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    List<Transaction> selectByExample(TransactionExample example);

    Transaction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Transaction record, @Param("example") TransactionExample example);

    int updateByExample(@Param("record") Transaction record, @Param("example") TransactionExample example);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}