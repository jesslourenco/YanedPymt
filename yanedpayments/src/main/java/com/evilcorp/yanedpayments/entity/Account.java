package com.evilcorp.yanedpayments.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal balance;

    public Account(){
        this.balance = BigDecimal.ZERO;
    }
}
