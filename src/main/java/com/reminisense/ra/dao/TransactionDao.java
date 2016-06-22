package com.reminisense.ra.dao;

import com.reminisense.ra.entity.TransactionEntity;

import java.util.List;

/**
 * Created by Nigs on 2016-05-17.
 */
public interface TransactionDao {
    TransactionEntity addTransaction(TransactionEntity transactionEntity);

    List<TransactionEntity> listTransactions();
}
