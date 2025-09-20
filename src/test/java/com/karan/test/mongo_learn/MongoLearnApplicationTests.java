package com.karan.test.mongo_learn;


import com.karan.test.mongo_learn.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.karan.test.mongo_learn.repository.OrderRepository;

@SpringBootTest
class MongoLearnApplicationTests {
    @Autowired
    private OrderRepository repository;

    @Test
    void   createOrder(){
        Order  order = Order.builder()
                .status("pending ")
                .quantity(3)
                .totalPrice(980)
                .build();

        order =  repository.insert(order);
        System.out.println(order);
    }

}
