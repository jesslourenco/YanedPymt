package com.evilcorp.yanedpayments.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private LocalDateTime createdAt;

    private Integer fromAccount;
    private Integer toAccount;

    public Transaction(BigDecimal amount, TransactionType type, LocalDateTime createdAt, Integer fromAccount, Integer toAccount) {
        this.amount = amount;
        this.type = type;
        this.createdAt = createdAt;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }
}