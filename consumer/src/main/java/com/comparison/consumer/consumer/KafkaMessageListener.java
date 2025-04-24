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

    @KafkaListener(topics = "MyCustomerSave", autoStartup = "false")
    public void consumerMyCustomerSave(Customer customer) throws InterruptedException {
        log.debug("consumerMyCustomerSave:{}", customer);
        customerService.addCustomer(customer);
    }
}
