package com.vdg.ecommerce_website.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="parcel")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
		CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	// cost is kept as cost of product can change
	@Column(name="cost")
	private int cost;
	
	// Pending=0, Accepted=1, Delivered=2, Cancelled=3
	@Min(0)
	@Max(3)
	@Column(name="status")
	private int status;
	
	public Order() {}

	public Order(Customer customer, Product product) {
		this.product = product;
		this.customer = customer;
	}
	
	public Order(Customer customer, Product product, int cost) {
		this.product = product;
		this.customer = customer;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", customer=" + customer + ", cost=" + cost
				+ ", status=" + status + "]";
	}
	
}
