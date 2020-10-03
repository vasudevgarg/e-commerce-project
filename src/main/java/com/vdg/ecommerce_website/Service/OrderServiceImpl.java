package com.vdg.ecommerce_website.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdg.ecommerce_website.DAO.OrderRepository;
import com.vdg.ecommerce_website.Model.Customer;
import com.vdg.ecommerce_website.Model.Order;
import com.vdg.ecommerce_website.Model.Product;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderRepository orderRepository;
	
	@Autowired
	public OrderService orderService;
	
	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(int id) {
		Optional<Order> optionalOrder = orderRepository.findById(id);
		
		Order customOrder = null;
		if(optionalOrder.isPresent()==true) {
			customOrder = optionalOrder.get();
		}
		
		return customOrder;
	}

	@Override
	public List<Order> findByCustomer(Customer theCustomer) {
		return orderRepository.findByCustomer(theCustomer);
	}

	@Override
	public List<Order> findByStatus(int status) {
		return orderRepository.findByStatus(status);
	}

	@Override
	public void placeOrder(Customer theCustomer, List<Product> productList, List<Integer> priceList) {
		
		Order customOrder;
		
		for(int i=0;i<productList.size()&&i<priceList.size();i++) {
			customOrder = new Order(theCustomer,productList.get(i),priceList.get(i));
			orderRepository.save(customOrder);
		}
	}

	@Override
	public void changeOrderStatus(int orderId, int newStatus) {
			
		Order currentOrder = orderService.findById(orderId);
		if(currentOrder == null)
			return;
		currentOrder.setStatus(newStatus);
		orderRepository.save(currentOrder);
	}

	@Override
	public void save(Order currentOrder) {
		
		orderRepository.save(currentOrder);
	}

}
