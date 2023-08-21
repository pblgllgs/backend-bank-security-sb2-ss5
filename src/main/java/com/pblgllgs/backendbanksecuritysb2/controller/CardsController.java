package com.pblgllgs.backendbanksecuritysb2.controller;

import com.pblgllgs.backendbanksecuritysb2.entity.Cards;
import com.pblgllgs.backendbanksecuritysb2.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CardsController {

    private final CardsRepository cardsRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/myCards/{customerId}")
    public List<Cards> getCardDetails(@PathVariable int customerId) {
        return cardsRepository.findByCustomerId(customerId);
    }
}
