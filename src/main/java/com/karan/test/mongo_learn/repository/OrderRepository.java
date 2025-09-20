package com.karan.test.mongo_learn.repository;

import com.karan.test.mongo_learn.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository   extends MongoRepository<Order, String> {
    List<Order> findByStatus(String  status);
    List<Order> findByStatusAndQuantityGreaterThan(String  status , Integer  quantity);
}
