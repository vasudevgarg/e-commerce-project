package com.vdg.ecommerce_website.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vdg.ecommerce_website.Model.Agent;
import com.vdg.ecommerce_website.Model.Order;
import com.vdg.ecommerce_website.Service.AgentService;
import com.vdg.ecommerce_website.Service.OrderService;

@Controller
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	public OrderService orderService;
	
	@Autowired
	public AgentService agentService;
	
	@GetMapping("login")
	public String loginPage(Model model) {
		
		Agent theAgent = new Agent();
		model.addAttribute("theAgent", theAgent);
		return "agent/login";
	}
	
	@PostMapping("/authenticateAgent")
	public String authenticateAgent(@Valid @ModelAttribute("theAgent") Agent theAgent, BindingResult theBoBindingResult) {
		
		if(theBoBindingResult.hasErrors()) {
			return "agent/login";
		}
		
		String username = theAgent.getUsername();
		String password = theAgent.getPassword();
		
		Agent currentAgent = agentService.findByUsername(username);
		
		if(currentAgent==null)
			return "agent/login-fail";
					
		String actualPassword = currentAgent.getPassword();
		
		if(actualPassword.equals(password)) {
			return "redirect:/agent/getAllOrders";
		}
		
		return "agent/login-fail";
	}
	
	@GetMapping("/getAllOrders")
	public String getAllPendingOrders(Model model) {
		
		// pending orders status = 0
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);		
		return "agent/order-list";
	}
	
	@GetMapping("/updateOrderStatusToAccepted")
	public String updateOrderStatusToAccepted(@RequestParam("orderId") int id) {
		
		Order currentOrder = orderService.findById(id);
		if(currentOrder!=null) {
			currentOrder.setStatus(1);
			orderService.save(currentOrder);
		}
				
		return "redirect:/agent/getAllOrders";
	}
	
	@GetMapping("/updateOrderStatusToDelivered")
	public String updateOrderStatusToDelivered(@RequestParam("orderId") int id) {
		
		Order currentOrder = orderService.findById(id);
		if(currentOrder!=null) {
			currentOrder.setStatus(2);
			orderService.save(currentOrder);
		}
		
		return "redirect:/agent/getAllOrders";
	}
	
	@GetMapping("/updateOrderStatusToCancelled")
	public String updateOrderStatus(@RequestParam("orderId") int id) {
		
		Order currentOrder = orderService.findById(id);
		if(currentOrder!=null) {
			currentOrder.setStatus(3);
			orderService.save(currentOrder);
		}
		
		return "redirect:/agent/getAllOrders";
	}
	
}
