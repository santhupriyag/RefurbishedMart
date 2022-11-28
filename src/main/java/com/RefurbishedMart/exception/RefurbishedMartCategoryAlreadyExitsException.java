package com.RefurbishedMart.exception;

public class RefurbishedMartCategoryAlreadyExitsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public RefurbishedMartCategoryAlreadyExitsException(String errorMessage){
		super(errorMessage);
	}
	
	public RefurbishedMartCategoryAlreadyExitsException(String errorMessage,Exception e){
		super(errorMessage,e);
	}

}
