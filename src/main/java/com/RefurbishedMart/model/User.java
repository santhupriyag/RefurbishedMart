package com.RefurbishedMart.model;

import org.springframework.data.annotation.Id;
import javax.persistence.Table;

@Table(name ="user" )
public class User {
	
	@Id
	private Integer userid;
	
	private String username;
	
	private String password;
	
	private String status;
	
	private String usertype;
	
	private Contact contact;
	
	public User() {
		
	}

	public User(Integer userid, String username, String password, String status, String usertype, Contact contact) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.status = status;
		this.usertype = usertype;
		this.contact = contact;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	
	

}
