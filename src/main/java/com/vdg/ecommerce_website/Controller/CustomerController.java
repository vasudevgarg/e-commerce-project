package com.vdg.ecommerce_website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vdg.ecommerce_website.CustomClass.CustomProductCustomer;
import com.vdg.ecommerce_website.Model.Customer;
import com.vdg.ecommerce_website.Model.Order;
import com.vdg.ecommerce_website.Model.Product;
import com.vdg.ecommerce_website.Service.CustomerService;
import com.vdg.ecommerce_website.Service.OrderService;
import com.vdg.ecommerce_website.Service.ProductService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("login")
	public String loginForm(Model model) {
		
		Customer theCustomer = new Customer();
		model.addAttribute("theCustomer",theCustomer);
		return "customer/login";
	}
	
	@PostMapping("/checkOTP")
	public String checkOTP(@ModelAttribute("mobNo") String id, Model model) {
		
		Customer currentCustomer = customerService.findByMobNo(id);

		if(currentCustomer == null)
			return "customer/login-fail";
		
		model.addAttribute("theCustomer", currentCustomer);
		return "customer/otp-confirmation";
	}
	
	@PostMapping("/authenticateUser")
	public String authenticateUser(@ModelAttribute("id") int id) {

		Customer currentCustomer = customerService.findById(id);

		if(currentCustomer == null)
			return "customer/login-fail";
		
		return "redirect:/customer/getProductList?id="+currentCustomer.getId();
	}
	
	@GetMapping("/pastOrders")
	public String pastOrders(@RequestParam("id") int id ,Model model) {
		
		Customer theCustomer = customerService.findById(id);
		List<Order> customerOrders = orderService.findByCustomer(theCustomer);
		model.addAttribute("customerOrders", customerOrders);
		model.addAttribute("theCustomer", theCustomer);
		
		return "customer/past-orders-list";
	}
	
	@GetMapping("/getProductList")
	public String getProductList(@RequestParam("id") int id, Model model) {
		
		List<Product> productList = productService.getEligibleProductList();
		
		Customer theCustomer = customerService.findById(id);
		
		CustomProductCustomer customClass = new CustomProductCustomer(theCustomer, productList);
		
		model.addAttribute("modelClass", customClass);
		
		return "customer/product-list";
	}
	
	@GetMapping("/buyProducts")
	public String buyProducts(@RequestParam("id") int id, @RequestParam("productId") int productId, Model model) {
		
		Customer theCustomer = customerService.findById(id);
		Product theProduct = productService.getProductById(productId);
		int price = theProduct.getPrice();
		
		int stockAvailable = theProduct.getStock();
		if(stockAvailable<=0) {
			return "redirect:/customer/getProductList?id="+id;
		}

		Order newOrder = new Order(theCustomer, theProduct, price);
		
		theProduct.setStock(stockAvailable-1);
		productService.save(theProduct);
		orderService.save(newOrder);
		
		model.addAttribute("theCustomer", theCustomer);
		return "customer/order-success";
	}
}
