package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.model.User;

public interface CustomerService {

	String register(User user);

	List<User> getUsers();

}
