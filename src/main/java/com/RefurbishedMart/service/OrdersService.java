package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.model.Order;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface OrdersService {

	RefurbishedMartResponse saveOrders(Order order);

	List<Order> getUserOrders(String email);

	List<Order> getAllOrders();

	Order getOrderById(Long id);

	RefurbishedMartResponse changeOrderStatus(Order order);

}
