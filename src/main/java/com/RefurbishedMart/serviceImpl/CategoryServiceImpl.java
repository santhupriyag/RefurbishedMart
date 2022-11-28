package com.RefurbishedMart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.exception.RefurbishedMartCategoryAlreadyExitsException;
import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.repository.CategoryRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefurbishedMartResponse deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
