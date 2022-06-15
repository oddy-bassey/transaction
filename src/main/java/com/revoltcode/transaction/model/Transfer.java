package com.revoltcode.transaction.model;

import com.revoltcode.cqrs.core.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transfer extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotEmpty
    @Column
    private String senderAccountId;

    @NotEmpty
    @Column
    private String senderCustomerName;

    @NotEmpty
    @Column
    private String receiverAccountId;

    @NotEmpty
    @Column
    private String receiverCustomerName;

    @NotNull
    @Column
    private BigDecimal amount;

    @NotEmpty
    @Column
    private String description;
}
