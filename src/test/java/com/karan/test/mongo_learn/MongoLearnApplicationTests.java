package com.karan.test.mongo_learn;


import com.karan.test.mongo_learn.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.karan.test.mongo_learn.repository.OrderRepository;

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
        List<Order>  orders=  repository.findByStatusAndQuantityGreaterThan("pending ",3);
//        List<Order>  orders=  repository.findByStatus("pending ");
        orders.forEach(System.out::println);
    }

}
