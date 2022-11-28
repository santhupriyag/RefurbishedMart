package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.model.Cart;
import com.RefurbishedMart.repository.CartRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.CartService;
import com.RefurbishedMart.util.UUIDUtil;

@Component
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public RefurbishedMartResponse addTocart(Cart cart) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		boolean count=cartRepository.existsByProductid(cart.getProductid());
		System.out.println(count);
		if(count) {
			cartRepository.updateProductCount(cart.getProductid());
			response.setMessage(RefurbishedMartMessage.RM_CART_ADDED);
		}
		else {
		cartRepository.save(cart);
		response.setMessage(RefurbishedMartMessage.RM_CART_ADDED);
		}
		return response;
	}

	@Override
	public List<Cart> getUserCartProducts(String userid) {
		// TODO Auto-generated method stub
		return  (List<Cart>) cartRepository.findByUserid(userid);
	}

	@Override
	public List<Cart> getAllCartItems() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

	@Override
	public RefurbishedMartResponse deleteCart(Long id) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		cartRepository.deleteById(id);
		response.setMessage(RefurbishedMartMessage.RM_CART_DELETED);
		return response;
	}

}
