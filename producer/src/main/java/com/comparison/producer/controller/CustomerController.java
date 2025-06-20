package com.comparison.producer.Producer.controller;


import com.comparison.dto.CustomerRequestDTO;
import com.comparison.producer.Producer.service.KafkaEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @Autowired
    KafkaEventPublisher kafkaEventPublisher;

    @PostMapping("/add")
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerRequestDTO customer) throws ExecutionException, InterruptedException {
        log.debug("Enter addCustomer:{}", customer);
        kafkaEventPublisher.sendMessageToTopicAddCustomer(customer);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-async")
    public ResponseEntity<Void> addCustomerAsync(@RequestBody CustomerRequestDTO customer) throws ExecutionException, InterruptedException {
        log.debug("Enter addCustomerAsync:{}", customer);
        kafkaEventPublisher.sendMessageToTopicAddCustomerAsync(customer);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-reactive")
    public ResponseEntity<Void> addCustomerReactive(@RequestBody CustomerRequestDTO customer) throws ExecutionException, InterruptedException {
        log.debug("Enter addCustomerReactive:{}", customer);
        kafkaEventPublisher.sendMessageToTopicAddCustomerReactive(customer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-async-reactive")
    public ResponseEntity<Void> addCustomerAsyncReactive(@RequestBody CustomerRequestDTO customer) throws ExecutionException, InterruptedException {
        log.debug("Enter addCustomerReactive:{}", customer);
        kafkaEventPublisher.sendMessageToTopicAddCustomerAsyncReactive(customer);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/add/loadtest")
//    public ResponseEntity<Void> addCustomerLoadTest(@RequestBody Customer customer) {
//        log.debug("Enter addCustomerLoadTest:{}", customer);
//        String temp = customer.getCustomerName();
//
//        for (int a = 1; a <= 200000; a++) {
//            customer.setCustomerName(temp + a);
//            log.debug("customerName:" + customer.getCustomerName());
//            customerService.addCustomer(customer);
//        }
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/add/loadtest-async")
//    public ResponseEntity<Void> addCustomerLoadTestAsync(@RequestBody Customer customer) {
//        log.debug("Enter addCustomerLoadTestAsync:{}", customer);
//        String temp = customer.getCustomerName();
//        for (int a = 1; a <= 200000; a++) {
//            customer.setCustomerName(temp + a);
//            log.debug("customerName:" + customer.getCustomerName());
//            customerService.addCustomerAsync(customer);
//        }
//        return ResponseEntity.ok().build();
//    }
}

