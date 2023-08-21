package com.pblgllgs.backendbanksecuritysb2.controller;

import com.pblgllgs.backendbanksecuritysb2.entity.AccountTransactions;
import com.pblgllgs.backendbanksecuritysb2.repository.AccountTransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BalanceController {

    private final AccountTransactionsRepository accountTransactionsRepository;

    @PreAuthorize("hasRole('ADMIN')||hasRole('ROOT')")
    @GetMapping("/myBalance/{customerId}")
    public List<AccountTransactions> getBalanceDetails(@PathVariable int customerId) {
        return accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(customerId);
    }
}
