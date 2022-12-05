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
import com.RefurbishedMart.model.Order;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

public class OrdersControllerTest extends RefurbishedMartApiTest {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";

	String EMAIL = "spriya@gmail.com";

	public void saveOrderTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + SAVE_ORDER,
				new HttpEntity<String>(CommonUtility.getDummyOrder(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_ORDER_SUCCESS, result.getBody().getMessage());

	}

	@Test
	public void saveOrderNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + SAVE_ORDER, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}

	@Test
	public void getALlOrdersTest() throws JsonProcessingException {

		ResponseEntity<List<Order>> response = restTemplate.exchange(HTTP + randomServerPort + GET_ALL_ORDERS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
				});
		Assert.assertTrue(response.getBody().size() >= 0);
	}

	@Test
	public void getOrdersByUserTest() throws JsonProcessingException {

		ResponseEntity<List<Order>> response = restTemplate.exchange(
				HTTP + randomServerPort + GET_ORDER_BY_USER + EMAIL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Order>>() {
				});
		Assert.assertTrue(response.getBody().size() >= 0);
	}

	@Test
	public void getOrdersByIDTest() throws JsonProcessingException {
//		
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + SAVE_ORDER,
				new HttpEntity<String>(CommonUtility.getDummyOrder(), getHeaders()), RefurbishedMartResponse.class);

		ResponseEntity<List<Order>> response = restTemplate.exchange(HTTP + randomServerPort + GET_ALL_ORDERS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
				});

//		ResponseEntity<List<Order>> order = restTemplate.exchange(HTTP + randomServerPort + GET_ORDER_BY_ID + 100,
//				HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
//				});

	}

	@Test
	public void getOrdersByIDTNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> order = restTemplate
				.getForEntity(HTTP + randomServerPort + GET_ORDER_BY_ID + 121, RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, order.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, order.getBody().getErrorMessage());
	}

	public void changeOrderStatusNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + CHANGE_ORDER_STATUS, new HttpEntity<String>("", getHeaders()),
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
