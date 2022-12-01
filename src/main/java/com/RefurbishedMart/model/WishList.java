package com.RefurbishedMart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist")
public class WishList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlistid")
	private Long wishlistid;
	
	@Column(name = "userid")
	private String userid;
	
	@Column(name = "prodid")
	private String prodid;
	
	@Column(name = "prodname")
	private String prodname;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "imgpath")
	private String imgpath;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "description")
    private String description;
	
	public WishList() {
		
	}

	public WishList(Long wishlistid, String userid, String prodid, String prodname, String brand, String imgpath,
			Double price, String description) {
		this.wishlistid = wishlistid;
		this.userid = userid;
		this.prodid = prodid;
		this.prodname = prodname;
		this.brand = brand;
		this.imgpath = imgpath;
		this.price = price;
		this.description = description;
	}

	public Long getWishlistid() {
		return wishlistid;
	}

	public void setWishlistid(Long wishlistid) {
		this.wishlistid = wishlistid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
  
}
