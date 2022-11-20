package com.RefurbishedMart.controllerAPI;

import org.springframework.web.bind.annotation.RequestBody;

import com.RefurbishedMart.exception.RefurbishedMartAccountNotFound;
import com.RefurbishedMart.exception.RefurbishedMartAutheticationException;
import com.RefurbishedMart.exception.RefurbishedMartException;
import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartResponse;

public interface UserControllerAPI {

	
	public RefurbishedMartResponse login(@RequestBody User user) throws  RefurbishedMartAutheticationException, RefurbishedMartException, RefurbishedMartAccountNotFound;

	public RefurbishedMartResponse register(@RequestBody User user) throws RefurbishedMartInvalidDataException;

	public RefurbishedMartResponse forgotpassword(@RequestBody User user);

	public RefurbishedMartResponse logout(@RequestBody User user);

	public RefurbishedMartResponse editProfile(@RequestBody User user);

}
