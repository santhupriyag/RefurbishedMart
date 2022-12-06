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
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CustomerControllerTest extends RefurbishedMartApiTest {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";

	String FIRSTNAME = "priya";

	String USERNAME = "arun";

	@Test
	public void registerTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}

	@Test
	public void registerNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartErrorResponse> response = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartErrorResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_ACCOUNT_EXITS, response.getBody().getErrorMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}

	@Test
	public void registerNegativeTest1() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}

	@Test
	public void loginTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> reponse = this.restTemplate.postForEntity(
				HTTP + randomServerPort + LOGIN_USER,
				new HttpEntity<String>(CommonUtility.getDummyLogin(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_LOGIN_SUCCESS, reponse.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());
	}

	@Test
	public void loginNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartErrorResponse> reponse = this.restTemplate.postForEntity(
				HTTP + randomServerPort + LOGIN_USER,
				new HttpEntity<String>(CommonUtility.getDummyLoginNegative(), getHeaders()),
				RefurbishedMartErrorResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_AUTHNETICATION_FAILED, reponse.getBody().getErrorMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}

	@Test
	public void loginNegativeTest1() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartErrorResponse> reponse = this.restTemplate.postForEntity(
				HTTP + randomServerPort + LOGIN_USER,
				new HttpEntity<String>(CommonUtility.getDummyLoginNegative1(), getHeaders()),
				RefurbishedMartErrorResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_ACCOUNT_NOT_EXITS, reponse.getBody().getErrorMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}

	@Test
	public void loginNegativeTest2() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + LOGIN_USER, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}

	@Test
	public void userLogoutTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + USER_LOGOUT, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_LOGOUT, delete.getBody().getMessage());
	}

	@Test
	public void userEditTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<User> getUser = this.restTemplate.getForEntity(HTTP + randomServerPort + GET_USER_BY_MAIL,
				User.class);

		ResponseEntity<RefurbishedMartResponse> update = this.restTemplate.postForEntity(
				HTTP + randomServerPort + USER_EDIT_PROFILE,
				new HttpEntity<String>(CommonUtility.EditProfileDUmmy(getUser.getBody()), getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_USER_PROFILE_UPDATE_SUCCESS, update.getBody().getMessage());

		ResponseEntity<User> afterEdit = this.restTemplate.getForEntity(HTTP + randomServerPort + GET_USER_BY_MAIL,
				User.class);

		Assert.assertEquals(FIRSTNAME, afterEdit.getBody().getLastname());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}

	@Test
	public void userEditNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + USER_EDIT_PROFILE, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}

	@Test
	public void getUserByEmailTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<User> getUser = this.restTemplate.getForEntity(HTTP + randomServerPort + GET_USER_BY_MAIL,
				User.class);

		Assert.assertEquals(USERNAME, getUser.getBody().getUsername());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());

	}

	@Test
	public void getUserByEmailNegativeTest() throws JsonProcessingException {
		ResponseEntity<User> getUser = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_USER_BY_MAIL_NEGATIVE, User.class);
		Assert.assertEquals(null, getUser.getBody());
	}

	@Test
	public void userForgotPasswordTest() throws JsonProcessingException {
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_USER, new HttpEntity<String>(CommonUtility.getDummyUser(), getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_USER_REGISTRED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> forgot = this.restTemplate.postForEntity(
				HTTP + randomServerPort + USER_FORGOTPASSWORD,
				new HttpEntity<String>(CommonUtility.getDummyForgotPassword(), getHeaders()),
				RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PASSWORD_RESET_SUCCESS, forgot.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_USER, HttpMethod.DELETE, new HttpEntity<String>(getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_USER_DELETED, delete.getBody().getMessage());
	}

	@Test
	public void userForgotPasswordNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> forgot = this.restTemplate.postForEntity(
				HTTP + randomServerPort + USER_FORGOTPASSWORD,
				new HttpEntity<String>(CommonUtility.getDummyForgotPassword(), getHeaders()),
				RefurbishedMartErrorResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_ACCOUNT_NOT_EXITS, forgot.getBody().getErrorMessage());
	}

	@Test
	public void userForgotPasswordNegativeTest1() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + USER_FORGOTPASSWORD, new HttpEntity<String>("", getHeaders()),
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