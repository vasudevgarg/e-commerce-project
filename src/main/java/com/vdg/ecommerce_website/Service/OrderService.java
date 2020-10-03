package com.vdg.ecommerce_website.Service;

import java.util.List;

import com.vdg.ecommerce_website.Model.Customer;
import com.vdg.ecommerce_website.Model.Order;
import com.vdg.ecommerce_website.Model.Product;

public interface OrderService {

	List<Order> findAll();
	Order findById(int id);
	List<Order> findByCustomer(Customer theCustomer);
	List<Order> findByStatus(int status);
	void placeOrder(Customer theCustomer, List<Product> productList, List<Integer> priceList);
	void changeOrderStatus(int orderId, int newStatus);
	void save(Order currentOrder);
	
	
}
