package com.revoltcode.transaction.model;

import com.revoltcode.account.common.dto.TransactionType;
import com.revoltcode.cqrs.core.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transaction extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @NotEmpty
    @Column
    private String accountId;

    @NotEmpty
    @Column
    private String accountName;

    @NotNull
    @Column
    private TransactionType transactionType;

    @OneToOne
    @Column
    private Deposit deposit;

    @OneToOne
    @Column
    private Withdrawal withdrawal;

    @OneToOne
    @Column
    private Transfer transfer;

    @NotNull
    @Column
    private LocalDateTime transactionTime;

    @NotNull
    @Column
    private LocalDateTime createdDate;
}
