package com.RefurbishedMart.service;

import com.RefurbishedMart.exception.RefurbishedMartCategoryAlreadyExitsException;
import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface CategoryService {

	RefurbishedMartResponse addCategory(Category c) throws RefurbishedMartCategoryAlreadyExitsException;

	RefurbishedMartResponse updateCategory(Category c);

	RefurbishedMartResponse deleteCategory(Long categoryId);

}
