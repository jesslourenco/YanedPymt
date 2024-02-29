package com.evilcorp.yanedpayments.repository;

import com.evilcorp.yanedpayments.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByFromAccount(Integer fromAccount);
}