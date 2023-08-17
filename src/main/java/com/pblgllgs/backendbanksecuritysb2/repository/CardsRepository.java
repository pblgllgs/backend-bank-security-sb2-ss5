package com.pblgllgs.backendbanksecuritysb2.repository;

import com.pblgllgs.backendbanksecuritysb2.entity.Cards;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardsRepository extends CrudRepository<Cards, Long> {

    List<Cards> findByCustomerId(int customerId);

}