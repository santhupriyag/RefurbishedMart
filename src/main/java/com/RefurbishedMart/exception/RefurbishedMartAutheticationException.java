package com.RefurbishedMart.exception;

public class RefurbishedMartAutheticationException extends Exception {


	private static final long serialVersionUID = 1L;

	public RefurbishedMartAutheticationException(String errorMessage){
		super(errorMessage);
	}
	
	public RefurbishedMartAutheticationException(String errorMessage,Exception e){
		super(errorMessage,e);
	}
}
