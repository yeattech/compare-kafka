package com.comparison.consumer.service;

import com.comparison.consumer.entity.Customer;
import com.comparison.consumer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;



    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Async
    public CompletableFuture<Void> addCustomerAsync(Customer customer) {
        customerRepository.save(customer);
        log.debug("customerName:" + customer.getCustomerName());
        return CompletableFuture.completedFuture(null);
    }

}
