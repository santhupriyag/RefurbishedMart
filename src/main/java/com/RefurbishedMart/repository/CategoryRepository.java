package com.RefurbishedMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.RefurbishedMart.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	boolean existsByCategoryname(String categoryname);

	@Transactional
	void deleteByCategoryid(Long categoryId);

	Category findByCategoryid(Long categoryId);

}
