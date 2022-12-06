package com.RefurbishedMart.systemtest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AdminControllerTest extends RefurbishedMartApiTest {
	

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";
	
	@Test
	public void AdminregisterTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_ADMIN_USER, new HttpEntity<String>(CommonUtility.getDummyAdminUser(), getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_ADMIN_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}
	
	@Test
	public void registerNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_ADMIN_USER, new HttpEntity<String>(CommonUtility.getDummyAdminUser(), getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartErrorResponse> response = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_ADMIN_USER, new HttpEntity<String>(CommonUtility.getDummyAdminUser(), getHeaders()),
				RefurbishedMartErrorResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_ACCOUNT_EXITS, response.getBody().getErrorMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_ADMIN_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}
	
	@Test
	public void registerNegativeTest1() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_ADMIN_USER, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}

	@Test
	public void loginTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_ADMIN_USER, new HttpEntity<String>(CommonUtility.getDummyAdminUser(), getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> reponse = this.restTemplate.postForEntity(
				HTTP + randomServerPort + LOGIN_ADMIN_USER,
				new HttpEntity<String>(CommonUtility.getDummyAdminLogin(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_LOGIN_SUCCESS, reponse.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_ADMIN_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());
	}
	
	@Test
	public void loginNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_ADMIN_USER, new HttpEntity<String>(CommonUtility.getDummyAdminUser(), getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartErrorResponse> reponse = this.restTemplate.postForEntity(
				HTTP + randomServerPort + LOGIN_ADMIN_USER,
				new HttpEntity<String>(CommonUtility.getDummyAdminLoginNegative(), getHeaders()),
				RefurbishedMartErrorResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_AUTHNETICATION_FAILED, reponse.getBody().getErrorMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_ADMIN_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}
	
	@Test
	public void loginNegativeTest1() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_ADMIN_USER, new HttpEntity<String>(CommonUtility.getDummyAdminUser(), getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartErrorResponse> reponse = this.restTemplate.postForEntity(
				HTTP + randomServerPort + LOGIN_ADMIN_USER,
				new HttpEntity<String>(CommonUtility.getDummyAdminLoginNegative1(), getHeaders()),
				RefurbishedMartErrorResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_ACCOUNT_NOT_EXITS, reponse.getBody().getErrorMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_ADMIN_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}

	@Test
	public void loginNegativeTest2() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + LOGIN_ADMIN_USER, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}

	@Test
	public void userLogoutTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + _ADMIN_LOGOUT, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_LOGOUT, delete.getBody().getMessage());
	}
	
	@Test
	public void AdminEditNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADMIN_EDIT_PROFILE, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}

}
