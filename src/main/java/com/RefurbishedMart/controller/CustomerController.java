package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.controllerAPI.UserControllerAPI;
import com.RefurbishedMart.exception.RefurbishedMartAccountNotFound;
import com.RefurbishedMart.exception.RefurbishedMartAutheticationException;
import com.RefurbishedMart.exception.RefurbishedMartException;
import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.exception.RefurbishedMartUserBlockedException;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.CustomerService;
import com.RefurbishedMart.valueobject.ForgotPasswordVo;

@RestController
@RequestMapping("/customercontroller")
@CrossOrigin
public class CustomerController implements UserControllerAPI {

	@Autowired
	CustomerService CustomerService;

	@PostMapping("/userLogin")
	public RefurbishedMartResponse login(User user) throws RefurbishedMartAutheticationException, RefurbishedMartException, RefurbishedMartAccountNotFound, RefurbishedMartUserBlockedException {
		return CustomerService.login(user);
	}

	@PostMapping("/registerUser")
	public RefurbishedMartResponse register(User user) throws RefurbishedMartInvalidDataException {

		return CustomerService.register(user);
	}
	
	@DeleteMapping("/userLogout")
	public RefurbishedMartResponse logout() {

		return CustomerService.dologot();
	}
	@DeleteMapping("/userDelete/{email}")
	public RefurbishedMartResponse userDelete(@PathVariable String email) {

		return CustomerService.userDelete(email);
	}
	
	@PostMapping("/editProfile")
	public RefurbishedMartResponse editProfile(User user) {

		return  CustomerService.editProfile(user);
	}
	
	
	
	@GetMapping("/getUserByMail/{email}")
	public User getUserByMail(@PathVariable("email") String email) {

		return CustomerService.getUserByMail(email);
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {

		return CustomerService.getUsers();
	}
	
	@PostMapping("/forgotpassword")
	public RefurbishedMartResponse forgotpassword(@RequestBody ForgotPasswordVo  user) throws RefurbishedMartAccountNotFound {
		// TODO Auto-generated method stub
		return CustomerService.forgotpassword(user);
	}


}
