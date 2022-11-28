package com.RefurbishedMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RefurbishedMart.model.Product;
import com.RefurbishedMart.model.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProdid(String pId);

}
