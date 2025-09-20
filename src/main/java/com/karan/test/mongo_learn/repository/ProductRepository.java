package com.karan.test.mongo_learn.repository;

import com.karan.test.mongo_learn.entity.Order;
import com.karan.test.mongo_learn.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends MongoRepository<Product , Long> {

}
