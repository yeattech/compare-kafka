package com.comparison.consumer.repository;

import com.comparison.consumer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public List<Customer> findByCustomerName(String customerName);

}