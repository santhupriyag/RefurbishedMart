package com.RefurbishedMart.exception;

public class RefurbishedMartAccountNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public RefurbishedMartAccountNotFound(String errorMessage){
		super(errorMessage);
	}
	
	public RefurbishedMartAccountNotFound(String errorMessage,Exception e){
		super(errorMessage,e);
	}
}
