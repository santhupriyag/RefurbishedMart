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

import com.RefurbishedMart.model.Product;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.ProductService;

@RestController
@RequestMapping("/productcontroller")
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public RefurbishedMartResponse addProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		return productService.addProduct(product);
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
	
	@GetMapping("/findAllProducts")
	public List<Product> getProductList()
	{
		return productService.findAll();
	}
}
