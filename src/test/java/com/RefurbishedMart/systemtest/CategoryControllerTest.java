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
import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CategoryControllerTest extends RefurbishedMartApiTest {
	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";
	
	String NAME="Books";

	@Test
	public void addToCategoryTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategory(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
	}

	@Test
	public void addToCategoryNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategory(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<RefurbishedMartErrorResponse> reponse = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategory(), getHeaders()),
				RefurbishedMartErrorResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_EXITS, reponse.getBody().getErrorMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
	}

	@Test
	public void addToCategoryNegativeTest1() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}

	@Test
	public void updateCategoryTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategory(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);

		ResponseEntity<RefurbishedMartResponse> update = this.restTemplate.exchange(
				HTTP + randomServerPort + UPDATE_CATEGORY, HttpMethod.PUT,
				new HttpEntity<String>(CommonUtility.getDummyUpdateCategory(getCategory.getBody().getCategoryid()),
						getHeaders()),
				RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_UPDATED, update.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
	}

	@Test
	public void updateCategoryNegativeTest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> update = this.restTemplate.exchange(
				HTTP + randomServerPort + UPDATE_CATEGORY, HttpMethod.PUT,
				new HttpEntity<String>("",
						getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, update.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, update.getBody().getErrorMessage());
	}
	@Test
	public void deleteCategoryTest() throws JsonProcessingException {
		
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategory(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
		
		ResponseEntity<Category> afterDelete = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);
		
		Assert.assertEquals(null, afterDelete.getBody());
	}
	
	@Test
	public void getAllCategoryTest() throws JsonProcessingException {
		
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategory(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());
		
		ResponseEntity<List<Category>> response = restTemplate.exchange(HTTP + randomServerPort + GET_ALL_CATEGORYS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Category>>() {
				});
		
		Assert.assertTrue(response.getBody().size()>=0);
		
		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);
		
		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
		
	}
	
	@Test
	public void getAllCategoryNegativeTest() throws JsonProcessingException {
		
		ResponseEntity<List<Category>> response = restTemplate.exchange(HTTP + randomServerPort + GET_ALL_CATEGORYS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Category>>() {
				});
		Assert.assertTrue( response.getBody().size()>=0);
	}
	
	@Test
	public void getCategoryByIdTest() throws JsonProcessingException {
	
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategory(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);

		ResponseEntity<Category> getCategoryById = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_ID+getCategory.getBody().getCategoryid(), Category.class);
		
		Assert.assertEquals(NAME, getCategoryById.getBody().getCategoryname());
		
		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
		
		
	}
	
	@Test
	public void getCategoryByIdNegativeTest() throws JsonProcessingException {
		ResponseEntity<Category> getCategoryById = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_ID+100, Category.class);
		
		Assert.assertEquals(null, getCategoryById.getBody());
	}
	
	@Test
	public void getCategoryByNameTest() throws JsonProcessingException {
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategory(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);
		
		Assert.assertEquals(NAME, getCategory.getBody().getCategoryname());
		
		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
		
	}
	
	@Test
	public void getCategoryByNameNegativeTest() throws JsonProcessingException {
		
		ResponseEntity<Category> getCategoryById = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAME, Category.class);
		
		Assert.assertEquals(null, getCategoryById.getBody());
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}
}
