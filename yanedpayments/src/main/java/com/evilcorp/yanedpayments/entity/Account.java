package com.evilcorp.yanedpayments.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_id_sequence",
            sequenceName = "account_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_id_sequence"
    )
    private long id;
    private BigDecimal balance;
}
