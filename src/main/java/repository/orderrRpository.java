
public package repository;

import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

interface orderrRpository extends MongoRepository<Order , String> {

    
}