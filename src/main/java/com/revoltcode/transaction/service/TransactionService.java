package com.revoltcode.transaction.service;

import com.revoltcode.transaction.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionService {

    void save(Transaction transaction);
    Optional<Transaction> findById(UUID id);
    Optional<Transaction> findByAssociatedAccountId(String associatedAccountId);
    List<Transaction> findAll();
}
