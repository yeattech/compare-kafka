package com.comparison.consumer.consumer;

import com.comparison.consumer.entity.Customer;
import com.comparison.consumer.service.CustomerService;
import com.comparison.dto.CustomerRequestDTO;
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
    public void consumerAddCustomer(CustomerRequestDTO customerRequestDTO) throws InterruptedException {
        log.debug("consumerAddCustomer:{}", customerRequestDTO);
        Customer customer = new Customer(customerRequestDTO.getCustomerName(), customerRequestDTO.getContactNumber());
        customerService.addCustomer(customer);
    }

    @KafkaListener(topics = "AddCustomerAsync", autoStartup = "true")
    public void consumerAddCustomerAsync(CustomerRequestDTO customerRequestDTO) throws InterruptedException {
        log.debug("consumerAddCustomerAsync:{}", customerRequestDTO);
        Customer customer = new Customer(customerRequestDTO.getCustomerName(), customerRequestDTO.getContactNumber());
        customerService.addCustomerAsync(customer);
    }

    @KafkaListener(topics = "AddCustomerReactive", autoStartup = "true")
    public void consumerAddCustomerReactive(CustomerRequestDTO customerRequestDTO) throws InterruptedException {
        log.debug("consumerAddCustomerReactive:{}", customerRequestDTO);
        Customer customer = new Customer(customerRequestDTO.getCustomerName(), customerRequestDTO.getContactNumber());
        customerService.addCustomerReactive(customer);
    }
}
