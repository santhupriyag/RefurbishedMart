package com.RefurbishedMart.systemtest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RefurbishedMartApiTest {

//	Customer controller APIs
	String ADD_USER = "/RefurbishedMart/customercontroller/registerUser";

	String DELETE_USER = "/RefurbishedMart/customercontroller/userDelete/pa@gmail.com";
	
	String DELETE_USER_NEGATIVE = "/RefurbishedMart/customercontroller/userDelete/praveen@gmail.com";

	String LOGIN_USER = "/RefurbishedMart/customercontroller/userLogin";

	String USER_LOGOUT = "/RefurbishedMart/customercontroller/userLogout";

	String USER_EDIT_PROFILE="/RefurbishedMart/customercontroller/editProfile";
	
	String GET_USER_BY_MAIL="/RefurbishedMart/customercontroller/getUserByMail/pa@gmail.com";
	
	String GET_USER_BY_MAIL_NEGATIVE="/RefurbishedMart/customercontroller/getUserByMail/priya@gmail.com";
	
	String USER_FORGOTPASSWORD="/RefurbishedMart/customercontroller/forgotpassword";
	
	// Cart Controller APIs
	
	String ADD_TO_CART = "/RefurbishedMart/cartcontroller/addtocart";
	
	String GET_CART_BY_USERID="/RefurbishedMart/cartcontroller/getproductsbyuserid/1";
	
	String GET_ALL_CART_ITEMS="/RefurbishedMart/cartcontroller/getAllCartItems";
	
	
	String DELETE_CART_BY_ID="/RefurbishedMart/cartcontroller/cartproducts/";
	
	
	
}
