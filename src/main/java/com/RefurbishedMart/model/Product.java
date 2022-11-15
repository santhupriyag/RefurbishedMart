package com.RefurbishedMart.model;

public class Product {
	
	private Integer prodid;
	private String prodname;
	private Integer type;
	private String brand;
	private Category category;
	private String imgpath;
	private Double price;
    private String description;
    
    
	public Product() {

	}
	public Product(Integer prodid, String prodname, Integer type, String brand, Category category, String imgpath,
			Double price, String description) {
		super();
		this.prodid = prodid;
		this.prodname = prodname;
		this.type = type;
		this.brand = brand;
		this.category = category;
		this.imgpath = imgpath;
		this.price = price;
		this.description = description;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
