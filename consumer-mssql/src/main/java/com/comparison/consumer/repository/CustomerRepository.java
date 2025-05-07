package com.comparison.consumer.repository;

import com.comparison.consumer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    public List<Customer> findByCustomerName(String customerName);

}