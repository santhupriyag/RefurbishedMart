package com.RefurbishedMart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private Long categoryid;
	
	@Column(name = "categoryname")
	private String categoryname;
	
	
	public Category() {
		
	}
	public Category(Long categoryid, String categoryname) {
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	

}
