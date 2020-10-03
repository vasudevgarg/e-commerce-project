package com.vdg.ecommerce_website.Service;

import java.util.List;

import com.vdg.ecommerce_website.Model.Product;

public interface ProductService {

	List<Product> getProductList();
	List<Product> getEligibleProductList();
	Product getProductById(int id);
	void updateProduct(int parameter, String value);
	void deleteProduct(int id);
	void save(Product p);
	void addProduct(String name, String description, int price, int stock);
}