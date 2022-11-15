package com.RefurbishedMart.model;

import javax.persistence.Table;

@Table(name ="WishList" )
public class WishList {
	
	private String wishlistid;
	private String userid;
	private Product product;
	
	
	
	public WishList() {
		
	}
	public WishList(String wishlistid, String userid, Product product) {
		this.wishlistid = wishlistid;
		this.userid = userid;
		this.product = product;
	}
	public String getWishlistid() {
		return wishlistid;
	}
	public void setWishlistid(String wishlistid) {
		this.wishlistid = wishlistid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

    
  
}
