package com.RefurbishedMart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "prodid")
	private String prodid;
	
	@Column(name = "prodname")
	private String prodname;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "brand")
	private String brand;
	
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "imgpath")
	private String imgpath;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "description")
    private String description;
    
    
	public Product() {

	}
	public Product(Long id,String prodid, String prodname, String type, String brand, Category category, String imgpath,
			Double price, String description) {
	    this.id=id;
		this.prodid = prodid;
		this.prodname = prodname;
		this.type = type;
		this.brand = brand;
		this.category = category;
		this.imgpath = imgpath;
		this.price = price;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
