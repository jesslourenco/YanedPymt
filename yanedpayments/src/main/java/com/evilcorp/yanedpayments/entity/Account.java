package com.evilcorp.yanedpayments.entity;

import java.math.BigDecimal;


public class Account {
    private int id;
    private BigDecimal balance;

    public Account(BigDecimal balance){
        this.balance = BigDecimal.ZERO;
    }
}
