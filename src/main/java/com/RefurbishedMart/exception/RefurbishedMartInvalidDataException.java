package com.RefurbishedMart.exception;

public class RefurbishedMartInvalidDataException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public RefurbishedMartInvalidDataException(String errorMessage){
		super(errorMessage);
	}
	
	public RefurbishedMartInvalidDataException(String errorMessage,Exception e){
		super(errorMessage,e);
	}

}
