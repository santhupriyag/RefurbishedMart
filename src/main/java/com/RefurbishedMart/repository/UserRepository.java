package com.RefurbishedMart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.RefurbishedMart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByContact_Email(String email);

	User findByContact_Email(String email);

	User getUserByContact_Email(String email);

	List<User> findByUsertype(String rmRoleUser);

	@Transactional
	void deleteByUid(String id);
	
	@Modifying 
	@Transactional
	@Query(value = "update user set user.password =:password where user.contact_id =(select contact.id from contact where contact.email =:email)",nativeQuery = true)
	void savepassword(@Param("email") String email, @Param("password") String password);

}
