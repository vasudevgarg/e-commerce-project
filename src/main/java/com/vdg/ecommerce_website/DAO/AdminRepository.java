package com.vdg.ecommerce_website.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vdg.ecommerce_website.Model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByUsername(String username);

}
