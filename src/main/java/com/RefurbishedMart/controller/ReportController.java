package com.RefurbishedMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RefurbishedMart.model.Support;
import com.RefurbishedMart.service.ReportService;
import com.RefurbishedMart.valueobject.RevenueReport;
import com.RefurbishedMart.valueobject.SaleReport;

@RestController
@RequestMapping("/reportcontroller")
@CrossOrigin
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	
	 @GetMapping("/getSaleReport")
		public List<SaleReport> getSaleReport()  {

			return reportService.getSaleReport();
		}
	 
	 @GetMapping("/getRevenueReport")
		public List<RevenueReport> getRevenueReport()  {

			return reportService.getRevenueReport();
		}

}
