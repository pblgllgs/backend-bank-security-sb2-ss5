package com.pblgllgs.backendbanksecuritysb2.repository;

import com.pblgllgs.backendbanksecuritysb2.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Accounts,Long> {

    Accounts findByCustomerId(int customerId);
}
