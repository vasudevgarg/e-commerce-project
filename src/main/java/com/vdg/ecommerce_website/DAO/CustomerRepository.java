package com.vdg.ecommerce_website.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vdg.ecommerce_website.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByMobNo(String mobileNo);
	
}
