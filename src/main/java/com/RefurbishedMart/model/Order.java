package com.RefurbishedMart.model;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;


public class Order {
	
	private Integer orderid;
	
	private User user;
	
	private Integer totalprice;
	
	private String status;
	

	public Order() {
		
	}

	public Order(Integer orderid, User user, Integer totalprice, String status) {
		this.orderid = orderid;
		this.user = user;
		this.totalprice = totalprice;
		this.status = status;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

	
	
	

}
