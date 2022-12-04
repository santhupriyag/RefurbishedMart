package com.RefurbishedMart.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.model.Cart;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.CartService;

@RestController
@RequestMapping("/cartcontroller")
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addtocart")
	public RefurbishedMartResponse addToCart(@RequestBody Cart cart) {
		// TODO Auto-generated method stub
		return cartService.addTocart(cart);
	}
	

	@DeleteMapping("/cartproducts/{id}")
	public RefurbishedMartResponse deleteCart(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return cartService.deleteCart(id);
	}
	
     @GetMapping("/getproductsbyuserid/{userid}")
	public List<Cart> getUserCartProducts(@PathVariable(value="userid") String userid)
	{
		return cartService.getUserCartProducts(userid);
		
	}
 	@GetMapping("/getAllCartItems")
 	public List<Cart> getAllCartItems() 
 	{
 		return cartService.getAllCartItems();
 	}

}
