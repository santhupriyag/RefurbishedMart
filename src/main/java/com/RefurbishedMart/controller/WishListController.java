package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.model.WishList;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.WishListService;

@RestController
@RequestMapping("/wishlistcontroller")
@CrossOrigin
public class WishListController {

	@Autowired
	WishListService wishListService;

	@PostMapping("/addToWishlist")
	public RefurbishedMartResponse addToWishlist(@RequestBody WishList wishlist) {
		// TODO Auto-generated method stub
		return wishListService.addToWishlist(wishlist);
	}

	@DeleteMapping("/deleteFromWishlist/{id}")
	public RefurbishedMartResponse deleteFromWishlist(@PathVariable(value = "id") Long id) {
		// TODO Auto-generated method stub
		return wishListService.deleteFromWishlist(id);
	}

	@GetMapping("/getwishListbyuserid/{userid}")
	public List<WishList> getwishListbyuserid(@PathVariable(value = "userid") String userid) {
		return wishListService.getwishListbyuserid(userid);
	}

}
