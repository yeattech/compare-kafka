package com.comparison.consumer.consumer;

import com.comparison.consumer.entity.Customer;
import com.comparison.consumer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {
    @Autowired
    CustomerService customerService;

    @KafkaListener(topics = "AddCustomer", autoStartup = "true")
    public void consumerAddCustomer(Customer customer) throws InterruptedException {
        log.debug("consumerAddCustomer:{}", customer);
        customerService.addCustomer(customer);
    }

    @KafkaListener(topics = "AddCustomerAsync", autoStartup = "true")
    public void consumerAddCustomerAsync(Customer customer) throws InterruptedException {
        log.debug("consumerAddCustomerAsync:{}", customer);
        customerService.addCustomerAsync(customer);
    }
}
