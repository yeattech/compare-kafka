package com.comparison.consumer.repository;

import com.comparison.consumer.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositoryReactive extends ReactiveMongoRepository<Customer, String> {
    public List<Customer> findByCustomerName(String customerName);
}
