package com.RefurbishedMart.controllerAPI;

import org.springframework.web.bind.annotation.RequestBody;

import com.RefurbishedMart.exception.RefurbishedMartAccountNotFound;
import com.RefurbishedMart.exception.RefurbishedMartAutheticationException;
import com.RefurbishedMart.exception.RefurbishedMartException;
import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.exception.RefurbishedMartUserBlockedException;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.ForgotPasswordVo;

public interface UserControllerAPI {

	
	public RefurbishedMartResponse login(@RequestBody User user) throws  RefurbishedMartAutheticationException, RefurbishedMartException, RefurbishedMartAccountNotFound, RefurbishedMartUserBlockedException;

	public RefurbishedMartResponse register(@RequestBody User user) throws RefurbishedMartInvalidDataException;

	public RefurbishedMartResponse forgotpassword(@RequestBody ForgotPasswordVo user) throws RefurbishedMartAccountNotFound;

	public RefurbishedMartResponse logout();

	public RefurbishedMartResponse editProfile(@RequestBody User user);

}
