package com.evilcorp.yanedpayments.controller;

import com.evilcorp.yanedpayments.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // @GetMapping("/balance") // add path variable for id
    //public BigDecimal getBalance(@RequestParam long id){ return accountService.getBalance(id); }
}
