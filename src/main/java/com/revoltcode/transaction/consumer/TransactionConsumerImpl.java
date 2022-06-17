package com.revoltcode.transaction.consumer;

import com.revoltcode.account.common.dto.TransactionType;
import com.revoltcode.account.common.event.transaction.DepositedTransactionEvent;
import com.revoltcode.account.common.event.transaction.WithdrawnTransactionEvent;
import com.revoltcode.transaction.model.Deposit;
import com.revoltcode.transaction.model.Transaction;
import com.revoltcode.transaction.model.Withdrawal;
import com.revoltcode.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class TransactionConsumerImpl implements TransactionConsumer {

    private final TransactionService transactionService;

    @KafkaListener(topics = "DepositedTransactionEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(DepositedTransactionEvent event, Acknowledgment acknowledgment) {

        Transaction depositTransaction = Transaction.builder()
                .accountId(event.getId())
                .transactionType(TransactionType.DEPOSIT)
                .deposit(Deposit.builder()
                        .amount(BigDecimal.valueOf(event.getAmount()))
                        .description(event.getDescription())
                        .build())
                .transactionTime(event.getTransactionTime())
                .createdDate(LocalDateTime.now())
                .build();

        transactionService.save(depositTransaction);
        acknowledgment.acknowledge();
    }

    @KafkaListener(topics = "WithdrawnTransactionEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(WithdrawnTransactionEvent event, Acknowledgment acknowledgment) {
        Transaction withdrawTransaction = Transaction.builder()
                .accountId(event.getId())
                .transactionType(TransactionType.DEPOSIT)
                .withdrawal(Withdrawal.builder()
                        .amount(BigDecimal.valueOf(event.getAmount()))
                        .description(event.getDescription())
                        .build())
                .transactionTime(event.getTransactionTime())
                .createdDate(LocalDateTime.now())
                .build();

        transactionService.save(withdrawTransaction);
        acknowledgment.acknowledge();
    }
}
