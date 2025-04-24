package com.comparison.consumer.service;

import com.comparison.consumer.entity.Customer;
import com.comparison.consumer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
