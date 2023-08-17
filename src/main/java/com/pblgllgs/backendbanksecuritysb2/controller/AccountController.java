package com.pblgllgs.backendbanksecuritysb2.controller;

import com.pblgllgs.backendbanksecuritysb2.entity.Accounts;
import com.pblgllgs.backendbanksecuritysb2.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountController {

    private final AccountsRepository accountsRepository;

    @GetMapping ("/myAccount/{customerId}")
    public Accounts getAccountDetails(@PathVariable int customerId) {
        Accounts accounts = accountsRepository.findByCustomerId(customerId);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }
}
