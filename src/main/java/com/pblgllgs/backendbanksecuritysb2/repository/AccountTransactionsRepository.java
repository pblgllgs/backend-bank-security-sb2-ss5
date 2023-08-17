package com.pblgllgs.backendbanksecuritysb2.repository;

import com.pblgllgs.backendbanksecuritysb2.entity.AccountTransactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {
    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
