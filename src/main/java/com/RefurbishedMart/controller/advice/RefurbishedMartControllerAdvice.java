package com.RefurbishedMart.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.RefurbishedMart.constant.RefurbishedMartCode;
import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.exception.RefurbishedMartAccountNotFound;
import com.RefurbishedMart.exception.RefurbishedMartAutheticationException;
import com.RefurbishedMart.exception.RefurbishedMartCategoryAlreadyExitsException;
import com.RefurbishedMart.exception.RefurbishedMartException;
import com.RefurbishedMart.exception.RefurbishedMartInvalidDataException;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;

@ControllerAdvice(basePackages={"com.RefurbishedMart.controller"})
public class RefurbishedMartControllerAdvice {
	
private static final Logger LOG = LoggerFactory.getLogger(RefurbishedMartControllerAdvice.class);
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public RefurbishedMartErrorResponse hadleException(Exception e){
		LOG.error(e.getMessage(),e);
		return generateErrorResponse(RefurbishedMartMessage.RM_EXCPTION,RefurbishedMartCode.RM_EXCPTION);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Error.class)
	@ResponseBody
	public RefurbishedMartErrorResponse hadleError(Error e){
		LOG.error(e.getMessage(),e);
		return generateErrorResponse(RefurbishedMartMessage.RM_EXCPTION,RefurbishedMartCode.RM_EXCPTION);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RefurbishedMartException.class)
	@ResponseBody
	public RefurbishedMartErrorResponse RefurbishedMartException(RefurbishedMartException e){
		LOG.error(e.getMessage(),e);
		return generateErrorResponse(RefurbishedMartMessage.RM_EXCPTION,RefurbishedMartCode.RM_EXCPTION);
	}
	
	private RefurbishedMartErrorResponse generateErrorResponse(String errorMessage,String errorCode){
		RefurbishedMartErrorResponse errorResponse = new RefurbishedMartErrorResponse();
		errorResponse.setErrorCode(errorCode);
		errorResponse.setErrorMessage(errorMessage);
		return errorResponse;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(RefurbishedMartInvalidDataException.class)
	@ResponseBody
	public RefurbishedMartErrorResponse RefurbishedMartInvalidDataException(RefurbishedMartInvalidDataException e){
		LOG.error(e.getMessage(),e);
		return generateErrorResponse(RefurbishedMartMessage.RM_ACCOUNT_EXITS,RefurbishedMartCode.RM_ACCOUNT_EXITS);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(RefurbishedMartCategoryAlreadyExitsException.class)
	@ResponseBody
	public RefurbishedMartErrorResponse RefurbishedMartCategoryAlreadyExitsException(RefurbishedMartCategoryAlreadyExitsException e){
		LOG.error(e.getMessage(),e);
		return generateErrorResponse(RefurbishedMartMessage.RM_CATEGORY_EXITS,RefurbishedMartCode.RM_CATEGORY_EXITS);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(RefurbishedMartAutheticationException.class)
	@ResponseBody
	public RefurbishedMartErrorResponse RefurbishedMartAutheticationException(RefurbishedMartAutheticationException e){
		LOG.error(e.getMessage(),e);
		return generateErrorResponse(RefurbishedMartMessage.RM_AUTHNETICATION_FAILED,RefurbishedMartCode.RM_AUTHENTICATION_EXCPTION);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(RefurbishedMartAccountNotFound.class)
	@ResponseBody
	public RefurbishedMartErrorResponse AccountNotFound(RefurbishedMartAccountNotFound e){
		LOG.error(e.getMessage(),e);
		return generateErrorResponse(RefurbishedMartMessage.RM_ACCOUNT_NOT_EXITS,RefurbishedMartCode.RM_ACCOUNT_NOT_EXITS);
	}
	

}
