package com.evilcorp.yanedpayments.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Transaction {
    private long id;
    private BigDecimal amount;
    private Type type;
    private LocalDateTime createdAt;
    private Account fromAccount;
    private Account toAccount;
}
