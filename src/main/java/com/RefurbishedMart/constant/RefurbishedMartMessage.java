package com.RefurbishedMart.constant;

import org.springframework.stereotype.Component;

@Component
public interface RefurbishedMartMessage {

	String RM_EXCPTION = "Your request is unsuccessful.Please try again later.";
	String RM_ACCOUNT_EXITS = "Account Already Exists! Please Login";
	String RM_USER_REGISTRED = "User SucessFully Registred";
	String RM_USER_ACTIVE = "Active";
	String RM_ROLE_ADMIN = "ADMIN";
	String RM_ROLE_USER = "USER";
	String RM_AUTHNETICATION_FAILED = "Unable to Authenticate/Incorrect Username or Password";
	String RM_ACCOUNT_NOT_EXITS = "Account Not Exist, Please Register!";
	String RM_USER_LOGIN_SUCCESS = "User Login SucessFully";
	String RM_USER_PROFILE_UPDATE_SUCCESS = "User profile  updated SucessFully";
	String RM_CATEGORY_EXITS = "Category Already Exists!";
	String RM_CATEGORY_ADDED = "Category Added SucessFully!";
	String RM_PRODUCT_ADDED = "Product Added SucessFully!";
	String RM_PRODUCT_UPDATE_SUCCESS = "Product updated SucessFully!";
	String RM_CART_ADDED = "Product added to Cart SucessFully!";
	String RM_CART_DELETED = "Product Deleted SucessFully!";

}
