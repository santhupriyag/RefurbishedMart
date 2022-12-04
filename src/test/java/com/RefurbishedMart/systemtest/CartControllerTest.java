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
import com.RefurbishedMart.model.Cart;
import com.RefurbishedMart.model.User;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CartControllerTest extends RefurbishedMartApiTest {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";

	String NAME = "13 Pro Max";

	String PRODUCTID = "1";

	@Test
	public void addToCartTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_TO_CART,
				new HttpEntity<String>(CommonUtility.getDummyCart(), getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CART_ADDED, result.getBody().getMessage());

		ResponseEntity<List<Cart>> response = restTemplate.exchange(HTTP + randomServerPort + GET_CART_BY_USERID,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {
				});

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CART_BY_ID + response.getBody().get(0).getId(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_DELETE_SUCCESS, delete.getBody().getMessage());
	}

	@Test
	public void cartNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate
				.postForEntity(HTTP + randomServerPort + ADD_TO_CART, "", RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}

	@Test
	public void getAllCartItemsTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_TO_CART,
				new HttpEntity<String>(CommonUtility.getDummyCart(), getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CART_ADDED, result.getBody().getMessage());

		ResponseEntity<List<Cart>> response = restTemplate.exchange(HTTP + randomServerPort + GET_ALL_CART_ITEMS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {
				});

		Assert.assertEquals(NAME, response.getBody().get(0).getName());
		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CART_BY_ID + response.getBody().get(0).getId(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_DELETE_SUCCESS, delete.getBody().getMessage());
	}

	@Test
	public void getAllCartItemsNegativeTest() throws JsonProcessingException {

		ResponseEntity<List<Cart>> response = restTemplate.exchange(HTTP + randomServerPort + GET_ALL_CART_ITEMS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {
				});
		Assert.assertEquals(0, response.getBody().size());

	}

	@Test
	public void getCartByUserIdTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_TO_CART,
				new HttpEntity<String>(CommonUtility.getDummyCart(), getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CART_ADDED, result.getBody().getMessage());

		ResponseEntity<List<Cart>> response = restTemplate.exchange(HTTP + randomServerPort + GET_CART_BY_USERID,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {
				});
		Assert.assertEquals(PRODUCTID, response.getBody().get(0).getProductid());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CART_BY_ID + response.getBody().get(0).getId(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_DELETE_SUCCESS, delete.getBody().getMessage());
	}

	@Test
	public void getCartByUserIdNegativeTest() throws JsonProcessingException {
		ResponseEntity<List<Cart>> response = restTemplate.exchange(HTTP + randomServerPort + GET_CART_BY_USERID,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {
				});
		Assert.assertEquals(0, response.getBody().size());
	}

	@Test
	public void deleteCartTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_TO_CART,
				new HttpEntity<String>(CommonUtility.getDummyCart(), getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CART_ADDED, result.getBody().getMessage());

		ResponseEntity<List<Cart>> response = restTemplate.exchange(HTTP + randomServerPort + GET_ALL_CART_ITEMS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Cart>>() {
				});

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CART_BY_ID + response.getBody().get(0).getId(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_DELETE_SUCCESS, delete.getBody().getMessage());
	}

	@Test
	public void deleteCartdNegativeTest() throws JsonProcessingException {
		ResponseEntity<RefurbishedMartErrorResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CART_BY_ID + 1, HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, delete.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, delete.getBody().getErrorMessage());
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}

}
