package com.RefurbishedMart.valueobject;

public class SaleReport {
	
	private Long id;
	
	private String name;
	
	private String des;
	
	private String quantity;
	
	

	public SaleReport(Long id, String name, String des, String quantity) {
		this.id = id;
		this.name = name;
		this.des = des;
		this.quantity = quantity;
	}

	public SaleReport() {
		
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

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
