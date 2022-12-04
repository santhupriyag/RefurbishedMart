package com.RefurbishedMart.systemtest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.RefurbishedMart.model.Category;
import com.RefurbishedMart.valueobject.RevenueReport;
import com.RefurbishedMart.valueobject.SaleReport;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ReportControllerTest extends RefurbishedMartApiTest {
	
	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	String HTTP = "http://localhost:";
	
	@Test
	public void getSaleReportTest() throws JsonProcessingException {
		
		ResponseEntity<List<SaleReport>> response = restTemplate.exchange(HTTP + randomServerPort + GET_SALE_REPORT,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<SaleReport>>() {
				});
		Assert.assertTrue( response.getBody().size()>=0);
	}
	
	@Test
	public void getRevenueReportTest() throws JsonProcessingException {
		
		ResponseEntity<List<RevenueReport>> response = restTemplate.exchange(HTTP + randomServerPort + GET_REVENUE_REPORT,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<RevenueReport>>() {
				});
		Assert.assertTrue( response.getBody().size()>=0);
	}



}
