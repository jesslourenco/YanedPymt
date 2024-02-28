package com.evilcorp.yanedpayments.controller;

import com.evilcorp.yanedpayments.entity.Account;
import com.evilcorp.yanedpayments.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> listAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}/balance")
    public BigDecimal getAccountBalance(@PathVariable("id") Integer id){
        return accountService.getBalanceById(id);
    }

    @PostMapping
    public void createAccount(){
        accountService.createAccount();
    }
}
