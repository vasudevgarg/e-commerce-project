package com.vdg.ecommerce_website.Service;

import com.vdg.ecommerce_website.Model.Admin;

public interface AdminService {
	Admin findByUsername(String username);
}
