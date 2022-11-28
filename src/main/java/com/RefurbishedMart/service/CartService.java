package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.model.Cart;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface CartService {

	RefurbishedMartResponse addTocart(Cart cart);

	List<Cart> getUserCartProducts(String userid);

	List<Cart> getAllCartItems();

	RefurbishedMartResponse deleteCart(Long id);

}
