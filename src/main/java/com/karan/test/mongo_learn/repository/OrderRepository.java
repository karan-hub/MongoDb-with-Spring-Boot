package com.karan.test.mongo_learn.repository;

import com.karan.test.mongo_learn.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository   extends MongoRepository<Order, String> {
}
