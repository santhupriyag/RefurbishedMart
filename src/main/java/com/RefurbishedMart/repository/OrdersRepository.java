package com.RefurbishedMart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RefurbishedMart.model.Order;
import com.RefurbishedMart.valueobject.SaleReport;
@Repository
public interface OrdersRepository  extends JpaRepository<Order, Long>{

	List<Order> findByUserMail(String email);

	@Query(value = "SELECT\r\n" + 
			"product.prodid AS id,\r\n" + 
			"product.prodname AS name,\r\n" + 
			"product.description AS des,\r\n" + 
			"SUM(orderproducts.quantity) as quantity\r\n" + 
			"\r\n" + 
			"FROM\r\n" + 
			"product,\r\n" + 
			"orderproducts\r\n" + 
			"WHERE\r\n" + 
			"product.id = orderproducts.productid\r\n" + 
			"GROUP BY\r\n" + 
			"product.prodid,\r\n" + 
			"product.prodname,\r\n" + 
			"product.description",nativeQuery = true)
	String[] getSaleReport();

	@Query(value ="SELECT\r\n" + 
			"    product.prodid AS id,\r\n" + 
			"    product.prodname AS name,\r\n" + 
			"     SUM(orderproducts.quantity) as quantity,\r\n" + 
			"    SUM(\r\n" + 
			"        orderproducts.quantity * orderproducts.price\r\n" + 
			"    ) AS total_amount\r\n" + 
			"FROM\r\n" + 
			"    product,\r\n" + 
			"    orderproducts\r\n" + 
			"WHERE\r\n" + 
			"    product.id = orderproducts.productid\r\n" + 
			"GROUP BY\r\n" + 
			"    product.prodid,\r\n" + 
			"    product.prodname,\r\n" + 
			"    product.description",nativeQuery = true )
	String[] getRevnueReport();


	
	
}
