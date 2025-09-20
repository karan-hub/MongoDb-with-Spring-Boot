package com.karan.test.mongo_learn.repository;

import com.karan.test.mongo_learn.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository   extends MongoRepository<Order, String> {
    List<Order> findByStatus(String  status);
    List<Order> findByStatusAndQuantityGreaterThan(String  status , Integer  quantity);
    List<Order> findByStatusAndQuantityGreaterThanOrderByCreatedDateDesc(String  status , Integer  quantity);

    @Query("{ 'status': ?0, 'totalPrice': { $gte: ?1 } }")
    List<Order> findPendingOrdersAbovePrice(String status, double minPrice);

    @Query("{ 'createdAt': { $gte: ?0, $lt: ?1 } }")
    List<Order> findOrdersInDateRange(LocalDateTime start, LocalDateTime end);

}
