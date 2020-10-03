package com.vdg.ecommerce_website.Service;

import javax.validation.Valid;

import com.vdg.ecommerce_website.Model.Agent;

public interface AgentService {

	void save(@Valid Agent theAgent);

	Agent findByUsername(String username);

}
