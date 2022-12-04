package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.exception.RefurbishedMartCategoryAlreadyExitsException;
import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.repository.CategoryRepository;
import com.RefurbishedMart.repository.ProductRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public RefurbishedMartResponse addCategory(Category c) throws RefurbishedMartCategoryAlreadyExitsException {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		boolean count = categoryRepository.existsByCategoryname(c.getCategoryname());
		if (count) {
			throw new RefurbishedMartCategoryAlreadyExitsException(RefurbishedMartMessage.RM_CATEGORY_EXITS);
		}
		else {
			categoryRepository.save(c);
			response.setMessage(RefurbishedMartMessage.RM_CATEGORY_ADDED);
			
		}
		return response;
	}

	@Override
	public RefurbishedMartResponse updateCategory(Category c) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		categoryRepository.save(c);
		response.setMessage(RefurbishedMartMessage.RM_CATEGORY_UPDATED);
		return response;
	}

	@Override
	public RefurbishedMartResponse deleteCategory(Long categoryId) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		productRepository.deleteByCategory_Categoryid(categoryId);
		categoryRepository.deleteByCategoryid(categoryId);
		response.setMessage(RefurbishedMartMessage.RM_CATEGORY_DELETED);
		return response;
	}

	@Override
	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(String categoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryid(Long.parseLong(categoryId));
	}

	@Override
	public Category getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryname(name);
	}

}
