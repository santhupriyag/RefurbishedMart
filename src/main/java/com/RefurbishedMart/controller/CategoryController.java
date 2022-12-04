package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/updateCategory")
	public RefurbishedMartResponse updateCategory(@RequestBody Category c) {
		// TODO Auto-generated method stub
		return categoryService.updateCategory(c);
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public RefurbishedMartResponse deleteCategory(@PathVariable Long categoryId) {
		// TODO Auto-generated method stub
		return categoryService.deleteCategory(categoryId);
	}
	
	@GetMapping("/getAllCategorys")
	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		return categoryService.getAllCategorys();
	}
	
	@GetMapping("/getCategoryById/{categoryId}")
	public Category getCategoryById(@PathVariable String categoryId) {
		// TODO Auto-generated method stub
		return categoryService.getCategoryById(categoryId);
	}

	@GetMapping("/getCategoryByName/{name}")
	public Category getCategoryByName(@PathVariable String name) {
		// TODO Auto-generated method stub
		return categoryService.getCategoryByName(name);
	}

}
