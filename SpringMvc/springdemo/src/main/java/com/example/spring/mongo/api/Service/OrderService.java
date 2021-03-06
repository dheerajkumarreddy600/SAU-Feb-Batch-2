package com.example.spring.mongo.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.mongo.api.model.Order;
import com.example.spring.mongo.api.repo.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo OrderRepo;
	public String saveOrder(Order order) 
	{
		
		OrderRepo.save(order);
		return "Order successfully  saved" + order.getItemid();
	}

	public List<Order> getOrder() 
	{
		
		return OrderRepo.findAll();
	}

	public String deleteOrder(String id) 
	{
		
		OrderRepo.deleteById(id);
		return "Your Order deleted ";
	}

	public String updateItems(Order order) 
	{
		
		OrderRepo.save(order);
		return "Items list updated successfully " + order.getItemid();
	}
}
