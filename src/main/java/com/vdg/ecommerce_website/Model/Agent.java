package com.vdg.ecommerce_website.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="agent")
public class Agent {
	
	@Id	
	@NotBlank(message = "is required")
	@Column(name="username")
	private String username;
	
	@NotBlank(message = "is required")
	@Column(name="password")
	private String password;
		
	public Agent() {}

	public Agent(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Agent [username=" + username + "]";
	}
	
}
