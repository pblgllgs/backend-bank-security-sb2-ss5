package com.pblgllgs.backendbanksecuritysb2.repository;

import com.pblgllgs.backendbanksecuritysb2.entity.Loans;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loans,Long> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
