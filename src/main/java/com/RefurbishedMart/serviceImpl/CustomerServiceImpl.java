package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.model.User;
import com.RefurbishedMart.repository.UserRepository;
import com.RefurbishedMart.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	UserRepository userRepo;
	
	

	@Override
	public String register(User user) {
		user.setStatus("Active");
		user.setUsertype("USER");
		userRepo.save(user);
		return "customer saved" ;
	}
	
	@Override
	public List<User> getUsers() {
		
		return userRepo.findAll();
	}

}
