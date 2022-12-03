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
import com.RefurbishedMart.exception.RefurbishedMartUserBlockedException;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.repository.UserRepository;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.service.CustomerService;
import com.RefurbishedMart.status.UserStatus;
import com.RefurbishedMart.util.PasswordHashingUtility;
import com.RefurbishedMart.util.UUIDUtil;
import com.RefurbishedMart.valueobject.ForgotPasswordVo;

@Component
public class CustomerServiceImpl implements CustomerService {
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
			user.setUsertype(RefurbishedMartMessage.RM_ROLE_USER);
			user.setPassword(passwordHashingUtility.getPasswordHash(user.getPassword()));
			user.setUid(UUIDUtil.shortRandomUUID());
			userRepo.save(user);
			response.setMessage(RefurbishedMartMessage.RM_USER_REGISTRED);
			
		}
		return response;
	}

	@Override
	public List<User> getUsers() {

		return userRepo.findAll();
	}

	@Override
	public RefurbishedMartResponse login(User user) throws RefurbishedMartAutheticationException, RefurbishedMartException, RefurbishedMartAccountNotFound, RefurbishedMartUserBlockedException {
		RefurbishedMartResponse loginResponse = new RefurbishedMartResponse();
		boolean count = userRepo.existsByContact_Email(user.getContact().getEmail());
		if (count) {
			User reg = userRepo.findByContact_Email(user.getContact().getEmail());
           if(!reg.getStatus().equals(UserStatus.BLOCKED)) {
			String hashedPassword = reg.getPassword();
			boolean passwordVerified = verifyUserPassword(user.getPassword(), hashedPassword);
			if (passwordVerified) {

				loginResponse.setMessage(RefurbishedMartMessage.RM_USER_LOGIN_SUCCESS);
				loginResponse.setCode(HttpStatus.OK);
				return loginResponse;
			} else {
				throw new RefurbishedMartAutheticationException(RefurbishedMartMessage.RM_AUTHNETICATION_FAILED);
		
			}
		
}
else {
	throw new RefurbishedMartUserBlockedException(RefurbishedMartMessage.RM_USER_BLOCKED);
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
	public User getUserByMail(String email) {
		// TODO Auto-generated method stub
		return userRepo.getUserByContact_Email(email);
	}

	@Override
	public RefurbishedMartResponse editProfile(User user) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		userRepo.save(user);
		response.setMessage(RefurbishedMartMessage.RM_USER_PROFILE_UPDATE_SUCCESS);
		return response;
	}

	@Override
	public RefurbishedMartResponse forgotpassword(ForgotPasswordVo user) throws RefurbishedMartAccountNotFound {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		boolean count = userRepo.existsByContact_Email(user.getEmail());
		if (count) {
			userRepo.savepassword(user.getEmail(),passwordHashingUtility.getPasswordHash(user.getPassword()));
			response.setMessage(RefurbishedMartMessage.RM_PASSWORD_RESET_SUCCESS);
		}
		else {
			throw new RefurbishedMartAccountNotFound(RefurbishedMartMessage.RM_ACCOUNT_NOT_EXITS);
		}
		
		return response;
	}

	@Override
	public RefurbishedMartResponse dologot() {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		response.setMessage(RefurbishedMartMessage.RM_LOGOUT);
		return response;
	}

	@Override
	public RefurbishedMartResponse userDelete(String email) {
		RefurbishedMartResponse response = new RefurbishedMartResponse();
		userRepo.deleteByContact_Email(email);
		response.setMessage(RefurbishedMartMessage.RM_USER_DELETED);
		return response;
	}

}
