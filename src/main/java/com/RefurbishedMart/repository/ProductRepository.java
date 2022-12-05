package com.RefurbishedMart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.RefurbishedMart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProdid(String pId);

	@Transactional 
	void deleteByProdid(String prodid);

//	@Transactional 
//	void deleteByCategory(Long categoryId);
	@Transactional 
	void deleteByCategory_Categoryid(Long categoryId);

	

	List<Product> findByCategory_Categoryid(Long categoryid);

	List<Product> findByCategory_Categoryname(String cname);

}
