package com.RefurbishedMart.service;

import java.util.List;

import com.RefurbishedMart.valueobject.RevenueReport;
import com.RefurbishedMart.valueobject.SaleReport;

public interface ReportService {

	List<SaleReport> getSaleReport();

	List<RevenueReport> getRevenueReport();

}
