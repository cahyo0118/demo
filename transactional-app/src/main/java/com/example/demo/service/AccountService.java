package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        Account from = repo.findById(fromId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + fromId));

        Account to = repo.findById(toId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + toId));

        // deduct
        from.setBalance(from.getBalance().subtract(amount));

        // add
        to.setBalance(to.getBalance().add(amount));

        // auto-save because of JPA dirty checking

        if (amount.compareTo(BigDecimal.valueOf(500)) > 0) {
            throw new RuntimeException("Transfer too suspicious, rolling back");
        }
    }
}
