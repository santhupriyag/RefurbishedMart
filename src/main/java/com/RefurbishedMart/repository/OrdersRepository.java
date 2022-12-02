package com.RefurbishedMart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RefurbishedMart.model.Order;
@Repository
public interface OrdersRepository  extends JpaRepository<Order, Long>{

	List<Order> findByUserMail(String email);


}
