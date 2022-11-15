package com.RefurbishedMart.model;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Table(name ="Cart" )
public class Cart {
	
	@Id
	private String cartid;
	private String userid;
	private Product product;
	private Integer quantity;
	
	public Cart() {
	}
	public Cart(String cartid, String userid, Product product, Integer quantity) {
		this.cartid = cartid;
		this.userid = userid;
		this.product = product;
		this.quantity = quantity;
	}
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
