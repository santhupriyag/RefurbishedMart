package com.RefurbishedMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.exception.RefurbishedMartCategoryAlreadyExitsException;
import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.CategoryService;

@RestController
@RequestMapping("/categoryController")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public RefurbishedMartResponse addCategory(@RequestBody Category c) throws RefurbishedMartCategoryAlreadyExitsException {
		// TODO Auto-generated method stub
		return categoryService.addCategory(c);
	}
	
	@PostMapping("/updateCategory")
	public RefurbishedMartResponse updateCategory(@RequestBody Category c) {
		// TODO Auto-generated method stub
		return categoryService.updateCategory(c);
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public RefurbishedMartResponse deleteCategory(@PathVariable Long categoryId) {
		// TODO Auto-generated method stub
		return categoryService.deleteCategory(categoryId);
	}


}
