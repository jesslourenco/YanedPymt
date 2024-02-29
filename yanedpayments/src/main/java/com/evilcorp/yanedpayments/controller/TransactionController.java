package com.evilcorp.yanedpayments.controller;

import com.evilcorp.yanedpayments.data.TransactionDTO;
import com.evilcorp.yanedpayments.entity.Account;
import com.evilcorp.yanedpayments.entity.Transaction;
import com.evilcorp.yanedpayments.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/api/transactions/{id}")
    public Transaction getTransaction(@PathVariable("id") Integer id){
        return transactionService.getAccountTransaction(id);
    }

    @GetMapping("/api/{acc-id}/transactions")
    public List<Transaction> listAccountTransactions(@PathVariable("acc-id") Integer id){
        return transactionService.getAccountTransactions(id);
    }

    @PostMapping(value = "/api/{acc-id}/transactions", consumes = "application/json")
    public void createTransaction(@PathVariable("acc-id") Integer id, @RequestBody TransactionDTO transactionDTO){
        System.out.println(id);
        transactionService.createTransaction(transactionDTO, id);
    }
}
