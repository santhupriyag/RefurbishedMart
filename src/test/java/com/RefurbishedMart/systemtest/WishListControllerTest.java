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
import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

public class WishListControllerTest extends RefurbishedMartApiTest {
	
	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";
	
	String USERID="hsa@gmail.com";
	
	@Test
	public void addWishListTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_WISHLIST,
				new HttpEntity<String>(CommonUtility.getDummyWishList(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_WISHLIST_ADDED, result.getBody().getMessage());

	}
	
	@Test
	public void addToCategoryNegativeTest1() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_WISHLIST, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}
	
	@Test
	public void deleteWishListTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_WISHLIST + 4567, HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_WISHLIST_DELETED, delete.getBody().getMessage());
	}
	
	
	@Test
	public void getAllWishListTest() throws JsonProcessingException {
		
		ResponseEntity<List<Category>> response = restTemplate.exchange(HTTP + randomServerPort + GET_WISHLIST_BY_USERID+USERID,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Category>>() {
				});
		Assert.assertTrue( response.getBody().size()>=0);
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}

}
