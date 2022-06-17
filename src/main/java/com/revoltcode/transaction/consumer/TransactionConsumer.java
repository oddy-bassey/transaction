package com.revoltcode.transaction.consumer;

import com.revoltcode.account.common.event.transaction.*;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface TransactionConsumer {

    void consume(@Payload DepositedTransactionEvent event, Acknowledgment acknowledgment);
    void consume(@Payload WithdrawnTransactionEvent event, Acknowledgment acknowledgment);
}
