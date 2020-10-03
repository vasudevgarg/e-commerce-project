package com.vdg.ecommerce_website.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "is required")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "is required")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="(^[0-9]{10})")
	@Column(name="mobile_no", unique=true)
	private String mobNo;
		
	public Customer() {}
	public Customer(String firstName, String lastName, String mobNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNo = mobNo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobNo=" + mobNo + "]";
	}
	
}
