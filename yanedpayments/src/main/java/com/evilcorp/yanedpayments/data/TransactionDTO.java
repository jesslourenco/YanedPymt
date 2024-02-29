package com.evilcorp.yanedpayments.data;

import com.evilcorp.yanedpayments.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        BigDecimal amount,
        TransactionType type,
        Integer toAccount
) {
}
