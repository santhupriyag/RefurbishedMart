package com.RefurbishedMart.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.RefurbishedMart.model.Cart;
import com.RefurbishedMart.model.Product;

public class ProductController {
	
	public String addProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String updateProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteProduct(@PathVariable Integer prodid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String searchProduct(@PathVariable Integer prodid) {
		// TODO Auto-generated method stub
		return null;
	}
}
