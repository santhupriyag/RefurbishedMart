package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.model.Order;
import com.RefurbishedMart.model.Product;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.OrdersService;

@RestController
@RequestMapping("/ordercontroller")
@CrossOrigin
public class OrdersController {
	
	@Autowired
	OrdersService ordersservice;
	
	@PostMapping("/saveOrders")
	public RefurbishedMartResponse saveOrders(@RequestBody Order order) {
		// TODO Auto-generated method stub
		return ordersservice.saveOrders(order);
	}
	
	@GetMapping("/getUserOrders/{email}")
	public List<Order> getUserOrders(@PathVariable String email) {
		// TODO Auto-generated method stub
		return ordersservice.getUserOrders(email);
	}

}
