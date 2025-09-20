package com.karan.test.mongo_learn.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
