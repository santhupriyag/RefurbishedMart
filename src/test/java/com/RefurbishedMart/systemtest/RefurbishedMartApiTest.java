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
	
	//Category Controller APIs
	
	String ADD_CATEGORY="/RefurbishedMart/categoryController/addCategory";
	
	String UPDATE_CATEGORY="/RefurbishedMart/categoryController/updateCategory";
	
	String DELETE_CATEGORY="/RefurbishedMart/categoryController/deleteCategory/";
	
	String GET_ALL_CATEGORYS="/RefurbishedMart/categoryController/getAllCategorys";
	
	String GET_CATEGORY_BY_ID="/RefurbishedMart/categoryController/getCategoryById/";

	String GET_CATEGORY_BY_NAME="/RefurbishedMart/categoryController/getCategoryByName/Books";
	
	
	//SupportController APIs
	
	String ADD_SUPPORT="/RefurbishedMart/supportcontroller/saveSupport";
	
	String GET_SUPPORTS="/RefurbishedMart/supportcontroller/getSupports";
	
   
	//FeedBack Controller APIs
	
	String ADD_FEEDBACK="/RefurbishedMart/feedbackcontroller/saveFeedback";
	
	String GET_FEEDBACKS="/RefurbishedMart/feedbackcontroller/getFeedbacks";
	
	
	
}
