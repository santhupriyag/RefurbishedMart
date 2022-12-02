package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.exception.RefurbishedMartAccountNotFound;
import com.RefurbishedMart.exception.RefurbishedMartAutheticationException;
import com.RefurbishedMart.exception.RefurbishedMartException;
import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.exception.RefurbishedMartUserBlockedException;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.ForgotPasswordVo;

public interface CustomerService {

	RefurbishedMartResponse register(User user) throws RefurbishedMartInvalidDataException;

	List<User> getUsers();

	RefurbishedMartResponse login(User user) throws RefurbishedMartAutheticationException, RefurbishedMartException, RefurbishedMartAccountNotFound, RefurbishedMartUserBlockedException;

	User getUserByMail(String email);

	RefurbishedMartResponse editProfile(User user);

	RefurbishedMartResponse forgotpassword(ForgotPasswordVo user) throws RefurbishedMartAccountNotFound;

}
