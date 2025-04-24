package com.comparison.producer.Producer.service;

import com.comparison.producer.Producer.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class KafkaEventPublisher {
    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopicAddCustomer(Customer customer) {
        CompletableFuture<SendResult<String, Object>> future = template.send("AddCustomer", customer);
        future.whenComplete((stringObjectSendResult, throwable) -> {
            if (throwable == null) {
                log.debug("Sent message=[" + customer + "] with offset=[" + stringObjectSendResult.getRecordMetadata().offset() + "]");
            } else {
                log.debug("Unable to send message=[" + customer + "] due to : " + throwable.getMessage());
            }
        });
        // is a blocking call that waits for the result to be available or throws an exception if the operation fails.
//        future.get();
    }
}
