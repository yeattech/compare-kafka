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

    @KafkaListener(topics = "AddCustomer", autoStartup = "false")
    public void consumerAddCustomer(CustomerRequestDTO customerRequestDTO) throws InterruptedException {
        log.debug("consumerAddCustomer:{}", customerRequestDTO);
        Customer customer =  Customer.builder().customerName(customerRequestDTO.getCustomerName()).contactNumber(customerRequestDTO.getContactNumber()).build();
        customerService.addCustomer(customer);
    }

    @KafkaListener(topics = "AddCustomerAsync", autoStartup = "false")
    public void consumerAddCustomerAsync(CustomerRequestDTO customerRequestDTO) throws InterruptedException {
        log.debug("consumerAddCustomerAsync:{}", customerRequestDTO);
        Customer customer =  Customer.builder().customerName(customerRequestDTO.getCustomerName()).contactNumber(customerRequestDTO.getContactNumber()).build();
        customerService.addCustomerAsync(customer);
    }
}
