package com.RefurbishedMart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.RefurbishedMart.model.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long> {

	@Transactional
	void deleteByWishlistid(Long id);


	List<WishList> findAllByUserid(String userid);


	boolean existsByProdid(String prodid);



}
