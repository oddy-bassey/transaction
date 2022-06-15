package com.revoltcode.transaction.repository;

import com.revoltcode.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    Optional<Transaction> findByAssociatedAccountId(String accountId);
}
