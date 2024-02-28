package com.evilcorp.yanedpayments.service;
import com.evilcorp.yanedpayments.entity.Account;
import com.evilcorp.yanedpayments.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class AccountService {
    private final AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public BigDecimal getBalance(Integer id) {
        return accountRepo.findById(id).get().getBalance();
    }

    public void createAccount() {
        Account acc = new Account();
        accountRepo.save(acc);
    }
}
