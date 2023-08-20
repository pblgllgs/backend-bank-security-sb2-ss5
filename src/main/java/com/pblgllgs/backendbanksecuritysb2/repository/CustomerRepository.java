package com.pblgllgs.backendbanksecuritysb2.repository;

import com.pblgllgs.backendbanksecuritysb2.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByEmail(String email);
}
