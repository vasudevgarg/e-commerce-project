package com.vdg.ecommerce_website.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vdg.ecommerce_website.Model.Customer;
import com.vdg.ecommerce_website.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	//@Query("Select o from Order o where o.customer=?1")
	List<Order> findByCustomer(Customer theCustomer);

	List<Order> findByStatus(int status);

}
