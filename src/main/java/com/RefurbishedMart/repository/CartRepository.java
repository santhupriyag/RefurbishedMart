package com.RefurbishedMart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RefurbishedMart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>  {

	List<Cart> findByUserid(String userid);

	boolean existsByProductid(String productid);
	
	@Modifying
	@Transactional
	@Query(value = "update cart set quantity=quantity+1 where productid=:productid",nativeQuery = true)
	void updateProductCount(String productid);

	@Transactional
	void deleteByUserid(String userMail);

}
