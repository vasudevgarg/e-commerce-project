package com.vdg.ecommerce_website.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "is required")
	@Column(name="name")
	private String name;
	
	@NotBlank(message = "is required")
	@Column(name="description")
	private String description;
	
	@NotNull
	@Min(0)
	@Max(1000000000)
	@Column(name="price")
	private Integer price;
	
	@NotNull
	@Min(0)
	@Max(1000000000)
	@Column(name="stock")
	private Integer stock;
	
	@NotNull
	@Column(name="eligible")
	private Boolean eligible;
	
	public Product() {}
	
	public Product(String name, String description, Integer price, Integer stock, Boolean eligible) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.eligible = eligible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getEligible() {
		return eligible;
	}

	public void setEligible(Boolean eligible) {
		this.eligible = eligible;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
				+ stock + ", eligible=" + eligible + "]";
	}
	
}
