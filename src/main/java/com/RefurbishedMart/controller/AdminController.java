package com.RefurbishedMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.controllerAPI.UserControllerAPI;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.AdminService;

@RestController
@RequestMapping("/admincontroller")
@CrossOrigin
public class AdminController implements UserControllerAPI {
	
	@Autowired
	AdminService AdminService;

	
	public RefurbishedMartResponse login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/registerUser")
	public RefurbishedMartResponse register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public RefurbishedMartResponse forgotpassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public RefurbishedMartResponse logout(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public RefurbishedMartResponse editProfile(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
