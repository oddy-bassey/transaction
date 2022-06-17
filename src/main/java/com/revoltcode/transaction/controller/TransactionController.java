package com.revoltcode.transaction.controller;

import com.revoltcode.transaction.exception.TransactionNotFoundException;
import com.revoltcode.transaction.model.Transaction;
import com.revoltcode.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/")
    public ResponseEntity<?> getAllTransactions(){
        return new ResponseEntity<>(transactionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable("id") UUID id){
        Transaction transaction = transactionService.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(MessageFormat.format("No transaction exists with the id: {0}", id)));

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/byAccountId/{accountId}")
    public ResponseEntity<?> getTransactionByAccountId(@PathVariable("accountId") String accountId){
        List<Transaction> transaction = transactionService.findByAccountId(accountId);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}
