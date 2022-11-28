package com.RefurbishedMart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.RefurbishedMart.model.Product;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface ProductService {

	RefurbishedMartResponse addProduct(Product product);

	List<Product> findAll();

	ResponseEntity<Product> getProductById(String pId);

	RefurbishedMartResponse deleteProduct(String prodid);

	RefurbishedMartResponse updateProduct(Product product);

}
