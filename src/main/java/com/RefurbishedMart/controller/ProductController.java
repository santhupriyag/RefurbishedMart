package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PutMapping("/updateProduct")
	public RefurbishedMartResponse updateProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		return productService.updateProduct(product);
	}
	 @DeleteMapping("/deleteProduct/{id}")
	public RefurbishedMartResponse deleteProduct(@PathVariable(value = "id") String id) {
		// TODO Auto-generated method stub
		return productService.deleteProduct(id);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String pId) {
		return productService.getProductById(pId);

	}

	@GetMapping("/findAllProducts")
	public List<Product> getProductList() {
		return productService.findAll();
	}
	
	    @GetMapping("/getproductsbycategory/{categoryid}")
	    public List<Product> getAllProductsByCategory(@PathVariable(value="categoryid") Long categoryid)
	    {
	    	return productService.getAllProductsByCategory(categoryid);
	    }
}
