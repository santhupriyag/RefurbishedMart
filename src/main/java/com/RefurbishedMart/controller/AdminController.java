package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.controllerAPI.UserControllerAPI;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.service.AdminService;

@RestController
@RequestMapping("/admincontroller")
@CrossOrigin
public class AdminController implements UserControllerAPI {
	
	@Autowired
	AdminService AdminService;

	
	public String login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/registerUser")
	public String register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String forgotpassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String logout(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String editProfile(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
