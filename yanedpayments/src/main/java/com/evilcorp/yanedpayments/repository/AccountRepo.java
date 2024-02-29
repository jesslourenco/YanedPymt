package com.evilcorp.yanedpayments.repository;

import com.evilcorp.yanedpayments.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface AccountRepo extends JpaRepository<Account, Integer> {}