package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.RefurbishedMart.valueobject.ForgotPasswordVo;

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


	public RefurbishedMartResponse logout(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/editProfile")
	public RefurbishedMartResponse editProfile(User user) {

		return  adminService.editProfile(user);
	}
	
	@GetMapping("/getAdminByMail/{email}")
	public User getUserByMail(@PathVariable("email") String email) {

		return adminService.getAdminByMail(email);
	}
	
	@DeleteMapping("/deleteUserByid/{id}")
	public RefurbishedMartResponse deleteUserByid(@PathVariable("id") String id) {

		return adminService.deleteUserByid(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers() {

		return adminService.getUsers();
	}

	@Override
	public RefurbishedMartResponse forgotpassword(ForgotPasswordVo user) throws RefurbishedMartAccountNotFound {
		// TODO Auto-generated method stub
		return null;
	}
	
}
