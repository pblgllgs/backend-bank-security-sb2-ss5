package com.pblgllgs.backendbanksecuritysb2.controller;

import com.pblgllgs.backendbanksecuritysb2.entity.Loans;
import com.pblgllgs.backendbanksecuritysb2.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoansController {

    private final LoanRepository loanRepository;

    @GetMapping("/myLoans/{customerId}")
    public List<Loans> getLoanDetails(@PathVariable int customerId) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }

}
