package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.model.Product;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface ProductService {

	RefurbishedMartResponse addProduct(Product product);

	List<Product> findAll();

}
