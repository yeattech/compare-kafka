package com.comparison.producer.Producer.controller;


import com.comparison.producer.Producer.entity.Customer;
import com.comparison.producer.Producer.service.KafkaEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @Autowired
    KafkaEventPublisher kafkaEventPublisher;

    @PostMapping("/add")
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
        log.debug("Enter addCustomer:{}", customer);
        kafkaEventPublisher.sendMessageToTopicAddCustomer(customer);

        return ResponseEntity.ok().build();
    }

//    @PostMapping("/add-async")
//    public ResponseEntity<Void> addCustomerAsync(@RequestBody Customer customer) {
//        log.debug("Enter addCustomerAsync:{}", customer);
//        customerService.addCustomerAsync(customer);
//
//        return ResponseEntity.ok().build();
//    }

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

