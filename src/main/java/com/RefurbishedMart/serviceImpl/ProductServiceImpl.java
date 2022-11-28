package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.model.Product;
import com.RefurbishedMart.repository.ProductRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.ProductService;
import com.RefurbishedMart.util.UUIDUtil;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository prodRepo;

	@Override
	public RefurbishedMartResponse addProduct(Product product) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		product.setProdid(UUIDUtil.shortRandomUUID());
		prodRepo.save(product);
		response.setMessage(RefurbishedMartMessage.RM_PRODUCT_ADDED);
		return response;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return prodRepo.findAll();
	}

}
