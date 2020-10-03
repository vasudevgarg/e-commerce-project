package com.vdg.ecommerce_website.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdg.ecommerce_website.DAO.CustomerRepository;
import com.vdg.ecommerce_website.Model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer findById(int id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		
		Customer theCustomer = null;
		
		if(optionalCustomer.isPresent()==true) {
			theCustomer = optionalCustomer.get();
		}
		return theCustomer;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public void save(Customer theCustomer) {
		
		customerRepository.save(theCustomer);
	}

	@Override
	public Customer findByMobNo(String mobileNo) {
		Customer theCustomer = customerRepository.findByMobNo(mobileNo);
		return theCustomer;
	}

}
