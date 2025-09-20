package com.karan.test.mongo_learn;


import com.karan.test.mongo_learn.entity.Address;
import com.karan.test.mongo_learn.entity.Order;
import com.karan.test.mongo_learn.entity.Product;
import com.karan.test.mongo_learn.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.karan.test.mongo_learn.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MongoLearnApplicationTests {
    @Autowired
    private OrderRepository repository;

    @Test
    void   createOrder(){
        for (int i = 1; i < 15; i++) {
            Order order = Order.builder()
                    .status("pending")
                    .quantity((int) (Math.random()*10))
                    .totalPrice((int) (Math.random()*1000))
                    .address(Address.builder()
                            .city("nashik")
                            .country("india")
                            .zipCode("20202")
                            .street("ramshej")
                            .state("maharatra")
                            .build())
                    .products(List.of(productRepository.findAll().get(i-1)))
                    .build();
            order = repository.insert(order);
            System.out.println(order);
        }
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

    @Test
    void  deleteorder(){
        List<Order>  orders=  repository.findByStatus("pending ");
//        repository.deleteAll(orders);
//        repository.deleteById(orders.get(0).getId());
        repository.deleteAll();
    }

    @Test
    void getPage(){
        Pageable pageable =  PageRequest.of(10,5, Sort.by(Sort.Direction.DESC,"totalPrice"));
         Page<Order> page =  repository.findAll(pageable);
        List<Order> orders = page.getContent();
        orders.forEach(System.out::println);
    }

    @Test
    void  embedQuery(){
        List<Order>  orders =  repository.findByAddressCity("nashik");
        orders.forEach(System.out::println);
    }


//    product

    @Autowired
    private ProductRepository productRepository;
    @Test
    void  creteProduct(){
        boolean on =true;
        for (int i = 1; i < 15; i++) {
            if (on){
                Product dell =  Product.builder()
                        .name("Dell Latitude 3510 2-in-1 " +i)
                        .price((int) (Math.random()*1000))
                        .category("Electronics")
                        .build();
                productRepository.save(dell);
                on=false;

            }else{
                Product iPhone =  Product.builder()
                        .name("iPhone "+i)
                        .price((int) (Math.random() * 1000))
                        .category("Electronics")
                        .build();
                productRepository.save(iPhone);
                on =true;
            }

        }

    }

//    projection
    @Test
    void  findByCity(){
        List<Order> cities = repository.findByCity("nashik");
        cities.forEach(System.out::println);
    }
}
