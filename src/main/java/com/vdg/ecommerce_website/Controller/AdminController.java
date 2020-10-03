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

import com.vdg.ecommerce_website.Model.Admin;
import com.vdg.ecommerce_website.Model.Agent;
import com.vdg.ecommerce_website.Model.Customer;
import com.vdg.ecommerce_website.Model.Product;
import com.vdg.ecommerce_website.Service.AdminService;
import com.vdg.ecommerce_website.Service.AgentService;
import com.vdg.ecommerce_website.Service.CustomerService;
import com.vdg.ecommerce_website.Service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AgentService agentService;
	
	@GetMapping("/login")
	public String getCrediantials(Model model) {
		
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "admin/login";
	}
	
	@PostMapping("authenticateAdmin")
	public String authenticateAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "admin/login";
		}
		
		String username = admin.getUsername();
		String password = admin.getPassword();
		
		Admin currentAdmin = adminService.findByUsername(username);
		
		if(currentAdmin==null)
			return "admin/login-fail";
					
		String actualPassword = currentAdmin.getPassword();
		
		if(actualPassword.equals(password)) {
			return "redirect:/admin/home";
		}
		return "admin/login-fail";
	}
	
	@GetMapping("/home")
	public String getHomePage() {
		return "admin/adminHomePage";
	}
	
	@GetMapping("/addProduct")
	public String showFormForAdd(Model model) {
		
		Product product = new Product();
		model.addAttribute("product",product);
		return "product/addProductForm";
	}
	
	@PostMapping("/save")
	public String saveNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "product/addProductForm";
		}
		productService.save(product);
		return "redirect:/admin/home";
		
	}
	
	@GetMapping("/getProductList")
	public String getProductList(Model model) {
		
		List<Product> productList = productService.getProductList();
		model.addAttribute("productList",productList);
		return "product/ProductListPage";
	}
	
	@GetMapping("/updateProduct")
	public String updateForm(@RequestParam("productId") int id, Model model) {
		
		Product product = productService.getProductById(id);
		
		model.addAttribute("product", product);
		return "product/addProductForm";
	}
	
	@GetMapping("/addCustomer")
	public String showFormToAddCustomer(Model model) {
		
		Customer theCustomer = new Customer();
		model.addAttribute("theCustomer",theCustomer);
		return "admin/add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveNewCustomer(@Valid @ModelAttribute("theCustomer") Customer theCustomer, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "admin/add-customer";
		}
		
		try {
			customerService.save(theCustomer);
		} catch(Exception e) {
			return "admin/add-customer";
		}
		
		return "redirect:/admin/home";
	}
	
	@GetMapping("/addAgent")
	public String showFormToAddAgent(Model model) {
		
		Agent theAgent = new Agent();
		model.addAttribute("theAgent",theAgent);
		return "admin/add-agent";
	}
	
	@PostMapping("/saveAgent")
	public String saveNewAgent(@Valid @ModelAttribute("theAgent") Agent theAgent, BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "admin/add-agent";
		}
		
		try {
			agentService.save(theAgent);
		} catch(Exception e) {
			return "admin/add-agent";
		}
		
		return "redirect:/admin/home";
	}
}
