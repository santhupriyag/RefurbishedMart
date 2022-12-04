package com.RefurbishedMart.systemtest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.RefurbishedMart.constant.RefurbishedMartMessage;
import com.RefurbishedMart.model.Feedback;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SupportControllerTest extends RefurbishedMartApiTest {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";
	
	@Test
	public void addSupportTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_SUPPORT,
				new HttpEntity<String>(CommonUtility.getDummySupport(), getHeaders()), RefurbishedMartResponse.class);

		     Assert.assertEquals(RefurbishedMartMessage.RM_SUPPPORT_SAVED, result.getBody().getMessage());
	}
	
	@Test
	public void addSupportNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_SUPPORT, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}
	
	@Test
	public void getAllSupportTest() throws JsonProcessingException {

		ResponseEntity<List<Feedback>> response = restTemplate.exchange(HTTP + randomServerPort + GET_SUPPORTS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Feedback>>() {
				});
		
		Assert.assertTrue(response.getBody().size()>=0);

	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}
}
