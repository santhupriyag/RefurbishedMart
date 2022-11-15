package com.RefurbishedMart.controllerAPI;

import org.springframework.web.bind.annotation.RequestBody;

import com.RefurbishedMart.model.User;

public interface UserControllerAPI {

	public String login(@RequestBody User user);

	public String register(@RequestBody User user);

	public String forgotpassword(@RequestBody User user);

	public String logout(@RequestBody User user);

	public String editProfile(@RequestBody User user);

}
