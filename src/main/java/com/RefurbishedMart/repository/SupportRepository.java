package com.RefurbishedMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.RefurbishedMart.model.Support;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long> {

}
