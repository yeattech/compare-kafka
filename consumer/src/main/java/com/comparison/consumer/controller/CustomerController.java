package com.comparison.consumer.controller;

import com.comparison.consumer.entity.Customer;
import com.comparison.consumer.service.CustomerService;
import com.comparison.dto.CustomerRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        log.debug("Enter addCustomer:{}", customerRequestDTO);
        Customer customer = new Customer(customerRequestDTO.getCustomerName(), customerRequestDTO.getContactNumber());
        customerService.addCustomer(customer);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-async")
    public ResponseEntity<Void> addCustomerAsync(@RequestBody CustomerRequestDTO customerRequestDTO) {
        log.debug("Enter addCustomerAsync:{}", customerRequestDTO);
        Customer customer = new Customer(customerRequestDTO.getCustomerName(), customerRequestDTO.getContactNumber());
        customerService.addCustomerAsync(customer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-reactive")
    public ResponseEntity<Void> addCustomerReactive(@RequestBody CustomerRequestDTO customerRequestDTO) {
        log.debug("Enter addCustomerReactive:{}", customerRequestDTO);
        Customer customer = new Customer(customerRequestDTO.getCustomerName(), customerRequestDTO.getContactNumber());
        customerService.addCustomerReactive(customer);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add/loadtest")
    public ResponseEntity<Void> addCustomerLoadTest(@RequestBody Customer customer) {
        log.debug("Enter addCustomerLoadTest:{}", customer);
        String temp = customer.getCustomerName();

        for (int a = 1; a <= 200000; a++) {
            customer.setCustomerName(temp + a);
            log.debug("customerName:" + customer.getCustomerName());
            customerService.addCustomer(customer);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add/loadtest-async")
    public ResponseEntity<String> addCustomerLoadTestAsync(@RequestBody Customer customer) throws InterruptedException {
        log.debug("Enter addCustomerLoadTestAsync:{}", customer);
        String temp = customer.getCustomerName();
        for (int a = 1; a <= 1000000; a++) {
            customer.setCustomerName(temp + a);
            customerService.addCustomerAsync(customer);
        }
        log.debug("End addCustomerLoadTestAsync at: {}", Instant.now());
        return ResponseEntity.ok("OK");
    }
}
