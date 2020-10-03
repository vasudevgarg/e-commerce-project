package com.vdg.ecommerce_website.CustomClass;

import java.util.List;

import com.vdg.ecommerce_website.Model.Customer;
import com.vdg.ecommerce_website.Model.Product;

public class CustomProductCustomer {
	
	Customer customer;
	List<Product> productList;
	
	public CustomProductCustomer() {}

	public CustomProductCustomer(Customer customer, List<Product> productList) {
		this.customer = customer;
		this.productList = productList;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "CustomProductCustomer [customer=" + customer + ", productList=" + productList + "]";
	}
	
}
