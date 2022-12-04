package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.exception.RefurbishedMartCategoryAlreadyExitsException;
import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface CategoryService {

	RefurbishedMartResponse addCategory(Category c) throws RefurbishedMartCategoryAlreadyExitsException;

	RefurbishedMartResponse updateCategory(Category c);

	RefurbishedMartResponse deleteCategory(Long categoryId);

	List<Category> getAllCategorys();

	Category getCategoryById(String categoryId);

	Category getCategoryByName(String name);

}
