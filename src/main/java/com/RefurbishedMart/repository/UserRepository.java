package com.RefurbishedMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RefurbishedMart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	boolean existsByContact_Email(String email);

	User findByContact_Email(String email);

	User getUserByContact_Email(String email);

}
