package com.example.demo.controller;

import com.example.demo.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public Map<String, String> transfer(
            @RequestParam Long from,
            @RequestParam Long to,
            @RequestParam BigDecimal amount
    ) {
        service.transfer(from, to, amount);
        return Map.of("status", "success");
    }
}
