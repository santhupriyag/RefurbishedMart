package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.model.WishList;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface WishListService {

	RefurbishedMartResponse addToWishlist(WishList wishlist);

	RefurbishedMartResponse deleteFromWishlist(Long id);

	List<WishList> getwishListbyuserid(String userid);

}
