package com.comparison.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document(collection = "my_customer")
public class Customer {
    String customerName;
    String contactNumber;
}