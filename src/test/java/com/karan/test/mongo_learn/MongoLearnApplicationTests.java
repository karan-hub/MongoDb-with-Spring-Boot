package com.karan.test.mongo_learn;


import com.karan.test.mongo_learn.entity.Order;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.karan.test.mongo_learn.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MongoLearnApplicationTests {
    @Autowired
    private OrderRepository repository;

    @Test
    void   createOrder(){
        Order  order = Order.builder()
                .status("pending ")
                .quantity(5)
                .totalPrice(340)
                .build();

        order =  repository.insert(order);
        System.out.println(order);
    }

    @Test
     public  void  testGetOrder(){
//        List<Order>  orders=  repository.findByStatusAndQuantityGreaterThan("pending ",3);
        List<Order>  orders=  repository.findByStatusAndQuantityGreaterThanOrderByCreatedDateDesc("pending ",3);
//        List<Order>  orders=  repository.findByStatus("pending ");
        orders.forEach(System.out::println);
    }

    @Test
    public  void  CustomeQuery(){
//        List<Order> orders =  repository.findPendingOrdersAbovePrice("pending " ,200);
        LocalDateTime startDate = LocalDateTime.of(2025, 9, 20, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2025, 9, 20, 23, 59, 59,20);
        List<Order> orders = repository.findOrdersInDateRange(startDate, endDate);
        orders.forEach(System.out::println);
    }

}
