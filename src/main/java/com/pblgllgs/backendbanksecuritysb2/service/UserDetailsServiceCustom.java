package com.pblgllgs.backendbanksecuritysb2.service;

import com.pblgllgs.backendbanksecuritysb2.config.SecurityCustomer;
import com.pblgllgs.backendbanksecuritysb2.entity.Customer;
import com.pblgllgs.backendbanksecuritysb2.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceCustom implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customer = customerRepository.findByEmail(username);
        if (customer.isEmpty()){
            throw new UsernameNotFoundException("User details not found");
        }
        return new SecurityCustomer(customer.get(0));
    }
}
