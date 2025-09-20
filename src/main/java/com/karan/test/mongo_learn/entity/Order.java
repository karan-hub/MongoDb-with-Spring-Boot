package com.karan.test.mongo_learn.entity;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document
@CompoundIndex(name = "idx_quantity_status" , def = "{'status':1 ,'quantity':-1}")
//@CompoundIndex(name = "idx_address_city" , def = "{'city:1}")
public class Order {
    @Id
    private String id;

    private Integer quantity;
    @Indexed
    private String status;

    private  Integer totalPrice;

    private  Address address;

    @DBRef(lazy = true)
    private List<Product> products;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifed;

}
