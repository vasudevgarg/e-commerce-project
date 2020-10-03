package com.vdg.ecommerce_website.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vdg.ecommerce_website.Model.Product;

public interface ProductRepository extends JpaRepository< Product, Integer> {
	
	@Query("Select p from Product p where p.eligible=1")
	List<Product> findAllEligibleProducts();
}
