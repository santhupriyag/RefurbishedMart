package com.RefurbishedMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.controllerAPI.UserControllerAPI;
import com.RefurbishedMart.exception.RefurbishedMartAccountNotFound;
import com.RefurbishedMart.exception.RefurbishedMartAutheticationException;
import com.RefurbishedMart.exception.RefurbishedMartException;
import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.AdminService;

@RestController
@RequestMapping("/admincontroller")
@CrossOrigin
public class AdminController implements UserControllerAPI {
	
	@Autowired
	AdminService adminService;

	@PostMapping("/userLogin")
	public RefurbishedMartResponse login(User user) throws RefurbishedMartAutheticationException, RefurbishedMartException, RefurbishedMartAccountNotFound {
		return adminService.login(user);
	}

	@PostMapping("/registerUser")
	public RefurbishedMartResponse register(User user) throws RefurbishedMartInvalidDataException {

		return adminService.register(user);
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
