package com.comparison.consumer.service;

import com.comparison.consumer.entity.Customer;
import com.comparison.consumer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Async
    public void addCustomerAsync(Customer customer) {
        customerRepository.save(customer);
    }
}
