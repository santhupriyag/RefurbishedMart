package com.RefurbishedMart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class RefurbishedMartException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public RefurbishedMartException() {}
	
	public RefurbishedMartException(String errorMessage){
		super(errorMessage);
	}
	
	public RefurbishedMartException(String errorMessage,Exception e){
		super(errorMessage,e);
	}

}
