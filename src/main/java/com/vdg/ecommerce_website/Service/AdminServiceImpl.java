package com.vdg.ecommerce_website.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdg.ecommerce_website.DAO.AdminRepository;
import com.vdg.ecommerce_website.Model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin findByUsername(String username) {
		return adminRepository.findByUsername(username);
	}

}
