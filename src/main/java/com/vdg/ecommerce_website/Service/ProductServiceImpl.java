package com.vdg.ecommerce_website.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdg.ecommerce_website.DAO.ProductRepository;
import com.vdg.ecommerce_website.Model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public ProductRepository productRepo;
	
	@Override
	public List<Product> getProductList() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> getEligibleProductList() {
		return productRepo.findAllEligibleProducts();
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		
		Product theProduct = null;
		if(optionalProduct.isPresent()==true) {
			theProduct = optionalProduct.get();
		}
		return theProduct;
	}

	@Override
	public void save(Product p) {
		productRepo.save(p);
	}

	@Override
	public void addProduct(String name, String description, int price, int stock) {
		
		Product p = new Product(name,description,price,stock, true);
		productRepo.save(p);		
	}
}
