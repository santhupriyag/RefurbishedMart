package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.model.Order;
import com.RefurbishedMart.repository.CartRepository;
import com.RefurbishedMart.repository.OrdersRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.OrdersService;

@Component
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public RefurbishedMartResponse saveOrders(Order order) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		ordersRepository.save(order);
		response.setMessage(RefurbishedMartMessage.RM_ORDER_SUCCESS);
		cartRepository.deleteByUserid(order.getUserMail());
		return response;
	}

	@Override
	public List<Order> getUserOrders(String email) {
		
		return ordersRepository.findByUserMail(email);
	}

}
