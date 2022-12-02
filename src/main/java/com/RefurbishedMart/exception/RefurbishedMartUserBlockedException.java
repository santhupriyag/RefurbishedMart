package com.RefurbishedMart.exception;

public class RefurbishedMartUserBlockedException extends Exception

{

	private static final long serialVersionUID = 1L;

	public RefurbishedMartUserBlockedException(String errorMessage){
		super(errorMessage);
	}
	
	public RefurbishedMartUserBlockedException(String errorMessage,Exception e){
		super(errorMessage,e);
	}

}
