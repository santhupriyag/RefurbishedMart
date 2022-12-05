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
import com.RefurbishedMart.model.Product;
import com.RefurbishedMart.response.RefurbishedMartErrorResponse;
import com.RefurbishedMart.response.RefurbishedMartResponse;
import com.RefurbishedMart.valueobject.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ProductControllerTest  extends RefurbishedMartApiTest {


	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";
	
	String CNAME="TEST";
	
	String GET_CATEGORY_BY_NAMEE="/RefurbishedMart/categoryController/getCategoryByName/TEST";
	
	@Test
	public void addProductest() throws JsonProcessingException {
		
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategoryProduct(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAMEE, Category.class);

		ResponseEntity<RefurbishedMartResponse> add = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_PRODUCT,new HttpEntity<String>(CommonUtility.getDummyProduct(getCategory.getBody().getCategoryid(),getCategory.getBody().getCategoryname()), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_ADDED, add.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());

	}
	
	
	@Test
	public void addProducNegativetest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_PRODUCT, new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}
	
	@Test
	public void UpdateProductest() throws JsonProcessingException {
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategoryProduct(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAMEE, Category.class);


		ResponseEntity<RefurbishedMartResponse> add = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_PRODUCT,new HttpEntity<String>(CommonUtility.getDummyProduct(getCategory.getBody().getCategoryid(),getCategory.getBody().getCategoryname()), getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_ADDED, add.getBody().getMessage());
		
		
		ResponseEntity<List<Product>> response = restTemplate.exchange(HTTP + randomServerPort + GET_PRODUCT_CATEGORY_NAME+CNAME,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
				});
		
		ResponseEntity<RefurbishedMartResponse> update = this.restTemplate.exchange(
				HTTP + randomServerPort + UPDATE_PRODUCT,HttpMethod.PUT,new HttpEntity<String>(CommonUtility.getDummyProductUpadte(getCategory.getBody().getCategoryid(),getCategory.getBody().getCategoryname()), getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_UPDATE_SUCCESS, update.getBody().getMessage());

		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
	
	}
	
	@Test
	public void getAllProductsTest() throws JsonProcessingException {
		
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategoryProduct(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAMEE, Category.class);


		ResponseEntity<RefurbishedMartResponse> add = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_PRODUCT,new HttpEntity<String>(CommonUtility.getDummyProduct(getCategory.getBody().getCategoryid(),getCategory.getBody().getCategoryname()), getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_ADDED, add.getBody().getMessage());
		
		ResponseEntity<List<Product>> response = restTemplate.exchange(HTTP + randomServerPort + GET_ALL_PRODUCTS,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
				});
		
		Assert.assertTrue(response.getBody().size()>=0);
		
		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());
		
	}
	
	@Test
	public void updateProducNegativetest() throws JsonProcessingException {

		ResponseEntity<RefurbishedMartErrorResponse> result = this.restTemplate.exchange(
				HTTP + randomServerPort + UPDATE_PRODUCT, HttpMethod.PUT,new HttpEntity<String>("", getHeaders()),
				RefurbishedMartErrorResponse.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
		Assert.assertEquals(RefurbishedMartMessage.RM_EXCPTION, result.getBody().getErrorMessage());
	}
	
	@Test
	public void deleteProductNegativetest() throws JsonProcessingException {
		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_PRODUCT +123, HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_DELETE_SUCCESS, delete.getBody().getMessage());
	}
	
	@Test
	public void getProductByCategoryNametest() throws JsonProcessingException {
		
		ResponseEntity<RefurbishedMartResponse> result = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_CATEGORY,
				new HttpEntity<String>(CommonUtility.getDummyCategoryProduct(), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_ADDED, result.getBody().getMessage());

		ResponseEntity<Category> getCategory = this.restTemplate
				.getForEntity(HTTP + randomServerPort + GET_CATEGORY_BY_NAMEE, Category.class);

		ResponseEntity<RefurbishedMartResponse> add = this.restTemplate.postForEntity(
				HTTP + randomServerPort + ADD_PRODUCT,new HttpEntity<String>(CommonUtility.getDummyProduct(getCategory.getBody().getCategoryid(),getCategory.getBody().getCategoryname()), getHeaders()), RefurbishedMartResponse.class);

		Assert.assertEquals(RefurbishedMartMessage.RM_PRODUCT_ADDED, add.getBody().getMessage());

		ResponseEntity<List<Product>> response = restTemplate.exchange(HTTP + randomServerPort + GET_PRODUCT_CATEGORY_NAME+getCategory.getBody().getCategoryname(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
				});
		Assert.assertTrue(response.getBody().size()>=0);
		
		ResponseEntity<RefurbishedMartResponse> delete = this.restTemplate.exchange(
				HTTP + randomServerPort + DELETE_CATEGORY + getCategory.getBody().getCategoryid(), HttpMethod.DELETE,
				new HttpEntity<String>(getHeaders()), RefurbishedMartResponse.class);
		Assert.assertEquals(RefurbishedMartMessage.RM_CATEGORY_DELETED, delete.getBody().getMessage());

	}
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}
	
}
