package com.evilcorp.yanedpayments.repository;

import com.evilcorp.yanedpayments.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {}
