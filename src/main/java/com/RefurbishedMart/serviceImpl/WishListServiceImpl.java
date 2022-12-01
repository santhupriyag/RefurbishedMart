package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.model.WishList;
import com.RefurbishedMart.repository.WishListRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.WishListService;

@Component
public class WishListServiceImpl implements WishListService {
	
	@Autowired
	WishListRepository wishListRepository;

	@Override
	public RefurbishedMartResponse addToWishlist(WishList wishlist) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		
		boolean count=wishListRepository.existsByProdid(wishlist.getProdid());
		if(count) {
			response.setMessage(RefurbishedMartMessage.RM_WISHLIST_ADDED);		}
		else {
			wishListRepository.save(wishlist);
		response.setMessage(RefurbishedMartMessage.RM_WISHLIST_ADDED);		}
		return response;
	}

	@Override
	public RefurbishedMartResponse deleteFromWishlist(Long id) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		wishListRepository.deleteByWishlistid(id);
		response.setMessage(RefurbishedMartMessage.RM_WISHLIST_DELETED);		
		return response;
	}

	@Override
	public List<WishList> getwishListbyuserid(String userid) {
		// TODO Auto-generated method stub
		return wishListRepository.findAllByUserid(userid);
	}

}
