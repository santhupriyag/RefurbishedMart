package com.RefurbishedMart.model;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Table(name ="Category" )
public class Category {
	
	@Id
	private Integer categoryid;
	private String categoryname;
	
	
	public Category() {
		
	}
	public Category(Integer categoryid, String categoryname) {
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	

}
