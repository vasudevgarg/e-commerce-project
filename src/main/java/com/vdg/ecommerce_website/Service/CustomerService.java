package com.vdg.ecommerce_website.Service;

import java.util.List;

import com.vdg.ecommerce_website.Model.Customer;

public interface CustomerService {

	Customer findById(int id);
	List<Customer> findAll();
	void save(Customer theCustomer);
	Customer findByMobNo(String mobileNo);

}
