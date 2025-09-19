package com.karan.test.mongo_learn.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collation = "orders")
public class order {

    @Id
    private String id;

    private Integer quantity;
    private String status;
    
}
