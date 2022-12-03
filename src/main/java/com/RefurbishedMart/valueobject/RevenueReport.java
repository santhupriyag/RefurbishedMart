package com.RefurbishedMart.valueobject;

public class RevenueReport {
	
	private Long id;
	
	private String name;

	private String quantity;
	
	private String total;
	
	

	public RevenueReport() {
	
	}

	public RevenueReport(Long id, String name, String quantity, String total) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	

}
