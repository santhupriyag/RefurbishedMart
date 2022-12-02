package com.RefurbishedMart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.exception.RefurbishedMartAccountNotFound;
import com.RefurbishedMart.exception.RefurbishedMartAutheticationException;
import com.RefurbishedMart.exception.RefurbishedMartException;
import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.repository.UserRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.AdminService;
import com.RefurbishedMart.util.PasswordHashingUtility;
import com.RefurbishedMart.util.UUIDUtil;

@Component
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordHashingUtility passwordHashingUtility;

	@Override
	public RefurbishedMartResponse register(User user) throws RefurbishedMartInvalidDataException {

		RefurbishedMartResponse response = new RefurbishedMartResponse();
		boolean count = userRepo.existsByContact_Email(user.getContact().getEmail());
		if (count) {
			throw new RefurbishedMartInvalidDataException(RefurbishedMartMessage.RM_ACCOUNT_EXITS);
		} else {
			user.setStatus(RefurbishedMartMessage.RM_USER_ACTIVE);
			user.setUsertype(RefurbishedMartMessage.RM_ROLE_ADMIN);
			user.setPassword(passwordHashingUtility.getPasswordHash(user.getPassword()));
			user.setUid(UUIDUtil.shortRandomUUID());
			userRepo.save(user);
			response.setMessage(RefurbishedMartMessage.RM_USER_REGISTRED);
			
		}
		return response;
	}

	@Override
	public RefurbishedMartResponse login(User user) throws RefurbishedMartAutheticationException, RefurbishedMartException, RefurbishedMartAccountNotFound {
		RefurbishedMartResponse loginResponse = new RefurbishedMartResponse();
		boolean count = userRepo.existsByContact_Email(user.getContact().getEmail());
		if (count) {
			User reg = userRepo.findByContact_Email(user.getContact().getEmail());

			String hashedPassword = reg.getPassword();
			boolean passwordVerified = verifyUserPassword(user.getPassword(), hashedPassword);
			if (passwordVerified) {

				loginResponse.setMessage(RefurbishedMartMessage.RM_USER_LOGIN_SUCCESS);
				loginResponse.setCode(HttpStatus.OK);
				return loginResponse;
			} else {
				throw new RefurbishedMartAutheticationException(RefurbishedMartMessage.RM_AUTHNETICATION_FAILED);
		
			}
		} else {
			throw new RefurbishedMartAccountNotFound(RefurbishedMartMessage.RM_ACCOUNT_NOT_EXITS);
		}
	}
	
	private boolean verifyUserPassword(String password, String hashedPassword) throws RefurbishedMartException {
		if (passwordHashingUtility.verifyPassword(password, hashedPassword)) {
			return true;
		}
		return false;
	}

	@Override
	public RefurbishedMartResponse editProfile(User user) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		userRepo.save(user);
		response.setMessage(RefurbishedMartMessage.RM_USER_PROFILE_UPDATE_SUCCESS);
		return response;
	}

	@Override
	public User getAdminByMail(String email) {
		// TODO Auto-generated method stub
		return userRepo.getUserByContact_Email(email);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findByUsertype(RefurbishedMartMessage.RM_ROLE_USER);
	}

	@Override
	public RefurbishedMartResponse deleteUserByid(String id) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		userRepo.deleteByUid(id);
		response.setMessage(RefurbishedMartMessage.RM_USER_DELETED);
		return response;
	
	}

}
