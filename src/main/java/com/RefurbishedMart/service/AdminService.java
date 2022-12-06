package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.exception.RefurbishedMartAccountNotFound;
import com.RefurbishedMart.exception.RefurbishedMartAutheticationException;
import com.RefurbishedMart.exception.RefurbishedMartException;
import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.ForgotPasswordVo;

public interface AdminService {

	RefurbishedMartResponse register(User user) throws RefurbishedMartInvalidDataException;

	RefurbishedMartResponse login(User user) throws RefurbishedMartAutheticationException, RefurbishedMartException, RefurbishedMartAccountNotFound;

	RefurbishedMartResponse editProfile(User user);

	User getAdminByMail(String email);

	List<User> getUsers();

	RefurbishedMartResponse deleteUserByid(String id);

	RefurbishedMartResponse dologot();

	RefurbishedMartResponse forgotpassword(ForgotPasswordVo user) throws RefurbishedMartAccountNotFound;

}
