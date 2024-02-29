package com.evilcorp.yanedpayments.service;

import com.evilcorp.yanedpayments.data.TransactionDTO;
import com.evilcorp.yanedpayments.entity.Account;
import com.evilcorp.yanedpayments.entity.Transaction;
import com.evilcorp.yanedpayments.entity.TransactionType;
import com.evilcorp.yanedpayments.exception.BadRequestException;
import com.evilcorp.yanedpayments.exception.NotFoundException;
import com.evilcorp.yanedpayments.repository.AccountRepo;
import com.evilcorp.yanedpayments.repository.TransactionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepo transactionRepo;
    private final AccountRepo accountRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    public List<Transaction> getAccountTransactions(Integer fromId){
        return transactionRepo.findAllByFromAccount(fromId);
    }

    public Transaction getAccountTransaction(Integer id){
        return transactionRepo.findById(id).orElseThrow(() -> new NotFoundException(String.format("Transaction with id %s not found", id)));
    }

    @Transactional
    public void createTransaction(TransactionDTO transactionDTO, Integer fromId){
        Account acc = accountRepo.findById(fromId).orElseThrow(() -> new NotFoundException(String.format("Account with id %s not found", fromId)));

        if (transactionDTO.amount() == null || transactionDTO.type() == null){
            throw new BadRequestException(String.format("Missing information for transaction. Please provide amount and type of transaction."));
        }

        if (transactionDTO.type() == TransactionType.IN){
            Transaction transaction = new Transaction(transactionDTO.amount(), transactionDTO.type(), LocalDateTime.now(), fromId, null);
            transactionRepo.save(transaction);

            acc.setBalance(acc.getBalance().add(transaction.getAmount()));
            accountRepo.save(acc);

            return;
        }

        if (acc.getBalance().compareTo(transactionDTO.amount()) == -1){
            throw new BadRequestException(String.format("Insufficient funds at account %s . Current balance is %s", fromId, transactionDTO.amount()));
        }

        if (transactionDTO.toAccount() == null ){
            throw new BadRequestException(String.format("Please provide the account to which you will be sending a payment to."));
        }

        Transaction transaction = new Transaction(transactionDTO.amount(), transactionDTO.type(), LocalDateTime.now(), fromId, transactionDTO.toAccount());
        transactionRepo.save(transaction);

        acc.setBalance(acc.getBalance().subtract(transaction.getAmount()));
        accountRepo.save(acc);
    }
}
