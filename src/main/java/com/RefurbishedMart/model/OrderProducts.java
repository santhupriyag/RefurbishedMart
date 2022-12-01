package com.RefurbishedMart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderproducts")
public class OrderProducts {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "productid")
	private String productid;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "imgpath")
	private String imgpath;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private String price;

	public OrderProducts() {

	}

	public OrderProducts(Long id, String productid, String quantity, String imgpath, String description,
			String price) {
		this.id = id;
		this.productid = productid;
		this.quantity = quantity;
		this.imgpath = imgpath;
		this.description = description;
		this.price = price;
	}

	public Long getOrderid() {
		return id;
	}

	public void setOrderid(Long orderid) {
		this.id = orderid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


}
