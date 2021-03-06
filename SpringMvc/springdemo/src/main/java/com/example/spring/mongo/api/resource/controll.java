package com.example.spring.mongo.api.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.mongo.api.Service.OrderService;
import com.example.spring.mongo.api.model.Order;
import com.example.spring.mongo.api.repo.OrderRepo;

@RestController
public class controll {
	@Autowired
    private OrderRepo repo;
	@Autowired
	OrderService orderService;
	@PostMapping("/AddOrder")
	public String saveOrder(@RequestBody Order order) {
	
		return "Added book id"+orderService.saveOrder(order);
	}
	@GetMapping("/findAll")
	public List<Order> getOrder(){
		return orderService.getOrder();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOrder(@PathVariable String id) {
		
		return orderService.deleteOrder(id);
	}
	@PutMapping("/updateItems")
	public String updateItems(@RequestBody Order order)
	{
		return orderService.updateItems(order);
	}
}	
