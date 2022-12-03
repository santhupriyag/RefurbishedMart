package com.RefurbishedMart.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RefurbishedMart.repository.OrdersRepository;
import com.RefurbishedMart.service.ReportService;
import com.RefurbishedMart.valueobject.RevenueReport;
import com.RefurbishedMart.valueobject.SaleReport;

@Component
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	OrdersRepository ordersRepository;

	@Override
	public List<SaleReport> getSaleReport() {
		List<SaleReport> listReport=new ArrayList<SaleReport>();
		String[] report=ordersRepository.getSaleReport();
		for(String s:report) {
			
			String[] token=s.split(",");
			SaleReport sr=new SaleReport();
			sr.setId(Long.parseLong(token[0]));
			sr.setName(token[1]);
			sr.setDes(token[2]);
			sr.setQuantity(token[3]);
			listReport.add(sr);
		}
		return listReport;
	}

	@Override
	public List<RevenueReport> getRevenueReport() {
		List<RevenueReport> listReport=new ArrayList<RevenueReport>();
		String[] report=ordersRepository.getRevnueReport();
		for(String s:report) {
			
			String[] token=s.split(",");
			RevenueReport sr=new RevenueReport();
			sr.setId(Long.parseLong(token[0]));
			sr.setName(token[1]);
			sr.setQuantity(token[2]);
			sr.setTotal(token[3]);
			listReport.add(sr);
		}
		return listReport;
	}
}
