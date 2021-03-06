package com.example.spring.mongo.api.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.mongo.api.model.Order;

public interface OrderRepo extends MongoRepository<Order,String>{

}
